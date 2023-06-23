package com.example.FlipCommerce.controllers;

import com.example.FlipCommerce.dto.requestDto.OrderRequestDto;
import com.example.FlipCommerce.dto.responseDto.OrderResponseDto;
import com.example.FlipCommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<Object> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        try {
            OrderResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
            return new ResponseEntity<>(orderResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /* Get top 5 orders with the highest order value */
    @GetMapping("/top-5-orders-with-highest-order-value")
    public ResponseEntity<List<Integer>> top5OrdersWithHighestOrderValue(){
        List<Integer> list = orderService.top5OrdersWithHighestOrderValue();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* All the orders of a particular customer */
    @GetMapping("/all-order-of-particular-customer/{emailId}")
    public ResponseEntity<List<Integer>> allOrderOfParticularCustomer(@PathVariable String emailId){
        List<Integer> list = orderService.allOrderOfParticularCustomer(emailId);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Top 5 recently ordered orders of a customer */
    @GetMapping("/top-5-recently-orders")
    public ResponseEntity<List<Integer>> top5RecentlyOrders(){
        List<Integer> list = orderService.top5RecentlyOrders();
        Collections.reverse(list);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

}
