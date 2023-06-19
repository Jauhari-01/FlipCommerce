package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.dto.requestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responseDto.CustomerResponseDto;
import com.example.FlipCommerce.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public List<String> allFemaleCustomer() {
        return null;
    }

    @Override
    public List<String> allMaleCustomer() {
        return null;
    }

    @Override
    public List<String> customerAtLeastKOrders(Integer k) {
        return null;
    }
}
