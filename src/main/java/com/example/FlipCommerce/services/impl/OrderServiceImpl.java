package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.Enum.ProductStatus;
import com.example.FlipCommerce.dto.requestDto.OrderRequestDto;
import com.example.FlipCommerce.dto.responseDto.OrderResponseDto;
import com.example.FlipCommerce.exceptions.*;
import com.example.FlipCommerce.models.*;
import com.example.FlipCommerce.repository.CardRepository;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.repository.OrderRepository;
import com.example.FlipCommerce.repository.ProductRepository;
import com.example.FlipCommerce.services.OrderService;
import com.example.FlipCommerce.transformers.ItemTransformer;
import com.example.FlipCommerce.transformers.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantityException, InvalidQuantityException, InvalidCardException {

        /*Check customer exist or not.*/
        Customer customer = customerRepository.findByEmailId(orderRequestDto.getCustomerEmailId());
        if (customer == null){
            throw new CustomerNotFoundException("Customer does not exist.");
        }

        /*Check product exist or not.*/
        Optional<Product> productOpt = productRepository.findById(orderRequestDto.getProductId());
        if (productOpt.isEmpty()){
            throw  new ProductNotFoundException("Product does not exist.");
        }

        Product product = productOpt.get();

        /*Check product quantity exist or not.*/
        if (orderRequestDto.getRequiredQuantity() <= 0){
            throw new InvalidQuantityException("Please enter the valid quantity.");
        }

        if (product.getQuantity() < orderRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! The required quantity is not available.");
        }

        /*Check customer card exist or not*/
        Card card = cardRepository.findByCardNo(orderRequestDto.getCardNo());
        Date currDate = new Date();
        if (card == null || card.getCvv() != orderRequestDto.getCvv() ||
                currDate.after(card.getValidTill()) || card.getCustomer().getId() != customer.getId()){
            throw new InvalidCardException("Sorry! You can not use this card.");
        }

        /*Decrease the product quantity*/
        int newQuantity = product.getQuantity() - orderRequestDto.getRequiredQuantity();
        if (newQuantity == 0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }
        product.setQuantity(newQuantity); // Set the new quantity of product

        /*Create item*/
        Item item = ItemTransformer.itemRequestDtoToItem(orderRequestDto.getRequiredQuantity());
        item.setProduct(product);

        /*Create the order*/
        OrderEntity orderEntity = OrderTransformer.orderRequestDtoToOrderEntity(item, customer);

        /*Generate the masked card number like XXXXXXXXXX7865*/
        String maskedCard = generateMaskedCardNo(card);
        orderEntity.setCardUsed(maskedCard);
        orderEntity.getItems().add(item); // Update the item list
        item.setOrderEntity(orderEntity);

        OrderEntity savedOrder = orderRepository.save(orderEntity); // Saved order and item both
        customer.getOrders().add(savedOrder); // Update the order list

        /*Only Order one item*/
        product.getItems().add(savedOrder.getItems().get(0));

        /*Send mail*/
        String date = savedOrder.getDateOfOrder().toString().substring(0, 19);
        String text = "\tE-Store Online E-Commerce Website \n\n" +
                "Congrats!! \n" + customer.getName() + " your order number " + orderEntity.getOrderNo() +
                " has been ordered successfully. \n\n" +
                "Product name  : " + product.getName() + "\n" +
                "Product price : " + product.getPrice() + "\n" +
                "Order Date    : " + date + "\n\n" +
                "Thank you!!!" + "\n\n" + "no-reply this is automated generated mail.";

        sendMailToCustomer(text, customer.getEmailId()); // Call to mail sendMailToCustomer method

        /*Order(entity) --> Dto*/
        return OrderTransformer.orderToOrderResponseDto(savedOrder);
    }

    @Override
    public OrderEntity placeOrder(Card card, Cart cart) throws InsufficientQuantityException {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCardUsed(generateMaskedCardNo(card));
        orderEntity.setOrderNo(String.valueOf(UUID.randomUUID()));

        int totalValue = 0;
        for (Item item : cart.getItems()) {
            Product product = item.getProduct();
            /*Check product quantity exist or not*/
            if (item.getRequiredQuantity() > product.getQuantity()){
                throw new InsufficientQuantityException("Sorry! The required quantity is not available.");
            }

            /*Set the total value*/
            totalValue += item.getRequiredQuantity() * product.getPrice();
            int newQuantity = product.getQuantity() - item.getRequiredQuantity();
            product.setQuantity(newQuantity); // Set the new quantity of product
            if (newQuantity == 0){
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }

            /* Update the order entity to corresponding item */
            item.setOrderEntity(orderEntity);
        }

        orderEntity.setTotalValue(totalValue);
        orderEntity.setItems(cart.getItems()); // Update the item list
        orderEntity.setCustomer(cart.getCustomer());
        return orderEntity;
    }

    @Override
    public List<Integer> top5OrdersWithHighestOrderValue() {
        return orderRepository.top5OrdersWithHighestOrderValue();
    }

    @Override
    public List<Integer> allOrderOfParticularCustomer(String emailId) {
        Iterable<OrderEntity> orderEntityIterable = orderRepository.findAll();
        List<Integer> list = new ArrayList<>();

        /*Iterate whole order_info table*/
        for (OrderEntity order: orderEntityIterable) {
            if (order.getCustomer().getEmailId().equals(emailId)){
                list.add(order.getId());
            }
        }
        return list;
    }

    @Override
    public List<Integer> top5RecentlyOrders() {
        return orderRepository.top5RecentlyOrders();
    }

    private String generateMaskedCardNo(Card card) {
        String originalCardNo = card.getCardNo();
        String cardNo = "";
        for (int i = 0; i < originalCardNo.length()-4; i++) {
            cardNo += "X";
        }
        cardNo += originalCardNo.substring(originalCardNo.length()-4);
        return cardNo;
    }

    public void sendMailToCustomer(String text, String emailId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ecommerce7232@gmail.com");
        message.setTo(emailId);
        message.setSubject("Order Booked!!!");
        message.setText(text);
        emailSender.send(message);
    }
}
