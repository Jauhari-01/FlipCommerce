package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.dto.requestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responseDto.CustomerResponseDto;
import com.example.FlipCommerce.models.Cart;
import com.example.FlipCommerce.models.Customer;
import com.example.FlipCommerce.models.OrderEntity;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.services.CustomerService;
import com.example.FlipCommerce.transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        /*Dto --> Customer(entity)*/
        Customer customer = CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);
        Cart cart =  Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        /*Allocate to cart each customer, when add the customer*/
        customer.setCart(cart);

        /*Saved in database*/
        Customer savedCustomer = customerRepository.save(customer); /*Saved both customer and cart*/

        /*Customer(entity* --> Dto*/
        return CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
    }

    @Override
    public List<String> allFemaleCustomer() {
        List<String> customerList = new ArrayList<>();
        Iterable<Customer> customerIterable = customerRepository.findAll();

        /*Iterate whole customer table*/
        for (Customer cust : customerIterable) {
            if (cust.getGender().toString().equals("FEMALE")){
                customerList.add(cust.getName());
            }
        }
        return customerList;
    }

    @Override
    public List<String> allMaleCustomer() {
        List<String> customerList = new ArrayList<>();
        Iterable<Customer> customerIterable = customerRepository.findAll();

        /*Iterate whole customer table*/
        for (Customer cust : customerIterable) {
            if (cust.getGender().toString().equals("MALE")){
                customerList.add(cust.getName());
            }
        }
        return customerList;
    }

    @Override
    public List<String> customerAtLeastKOrders(Integer k) {
        HashMap<String, Integer> hm = new HashMap<>();
        Iterable<Customer> customerIterable = customerRepository.findAll();

        /*Iterate whole customer table*/
        for (Customer cust : customerIterable) {
            List<OrderEntity> orderEntityList = cust.getOrders();
            /*Iterate whole order_info table*/
            for (OrderEntity order: orderEntityList) {
                Customer customer = order.getCustomer();
                hm.put(customer.getName(), hm.getOrDefault(customer.getName(), 0) + 1);
            }
        }

        List<String> customerList = new ArrayList<>();
        for (String key : hm.keySet()) {
            /*Customer at least k orders*/
            if (hm.get(key) >= k){
                customerList.add(key);
            }
        }
        return customerList;
    }
}
