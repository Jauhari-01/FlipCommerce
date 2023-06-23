package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.dto.requestDto.ItemRequestDto;
import com.example.FlipCommerce.exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.exceptions.InsufficientQuantityException;
import com.example.FlipCommerce.exceptions.OutOfStockException;
import com.example.FlipCommerce.exceptions.ProductNotFoundException;
import com.example.FlipCommerce.models.Customer;
import com.example.FlipCommerce.models.Item;
import com.example.FlipCommerce.models.Product;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.repository.ProductRepository;
import com.example.FlipCommerce.services.ItemService;
import com.example.FlipCommerce.transformers.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Item createItem(ItemRequestDto itemRequestDto) throws ProductNotFoundException, CustomerNotFoundException, InsufficientQuantityException, OutOfStockException {

        Optional<Product> productOpt = productRepository.findById(itemRequestDto.getProductId());

        /*Check product exist or not.*/
        if (productOpt.isEmpty()){
            throw  new ProductNotFoundException("Product does not exist.");
        }

        Product product = productOpt.get();

        /*Check customer exist or not.*/
        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());

        if (customer == null){
            throw new CustomerNotFoundException("Customer does not exist.");
        }

        /*Check product quantity exist or not.*/
        if (product.getQuantity() == 0) {
            throw new OutOfStockException("Product is out of stock.");
        }

        if (product.getQuantity() < itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! The required quantity is not available.");
        }

        /*Dto --> Item(entity)*/
        return ItemTransformer.itemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
    }
}
