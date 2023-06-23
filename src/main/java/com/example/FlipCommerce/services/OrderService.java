package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.OrderRequestDto;
import com.example.FlipCommerce.dto.responseDto.OrderResponseDto;
import com.example.FlipCommerce.exceptions.*;
import com.example.FlipCommerce.models.Card;
import com.example.FlipCommerce.models.Cart;
import com.example.FlipCommerce.models.OrderEntity;

import java.util.List;

public interface OrderService {
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantityException, InvalidQuantityException, InvalidCardException;

    public OrderEntity placeOrder(Card card, Cart cart) throws InsufficientQuantityException;

    List<Integer> top5OrdersWithHighestOrderValue();

    List<Integer> allOrderOfParticularCustomer(String emailId);

    List<Integer> top5RecentlyOrders();
}