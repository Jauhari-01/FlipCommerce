package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responseDto.CustomerResponseDto;
import java.util.List;

public interface CustomerService {
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

    List<String> allFemaleCustomer();

    List<String> allMaleCustomer();

    List<String> customerAtLeastKOrders(Integer k);
}
