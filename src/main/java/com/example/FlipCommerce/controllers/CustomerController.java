package com.example.FlipCommerce.controllers;

import com.example.FlipCommerce.dto.requestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responseDto.CustomerResponseDto;
import com.example.FlipCommerce.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /*Add customer*/
    @PostMapping("/add-customer")
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
    }

    /* Get all female customers */
    @GetMapping("/all-female-customer")
    public ResponseEntity<List<String>> allFemaleCustomer(){
        List<String> customerList = customerService.allFemaleCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);

    }

    /* Get all male customers less than 45 */
    @GetMapping("/all-male-customer")
    public ResponseEntity<List<String>> allMaleCustomer(){
        List<String> customerList = customerService.allMaleCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);
    }

    /* Customers who have ordered at least 'k' orders */
    @GetMapping("/customer-at-least-k-orders")
    public ResponseEntity<List<String>> customerAtLeastKOrders(@RequestParam Integer k){
        List<String> customerList = customerService.customerAtLeastKOrders(k);
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);
    }
}
