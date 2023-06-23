package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.CheckOutCartRequestDto;
import com.example.FlipCommerce.dto.requestDto.ItemRequestDto;
import com.example.FlipCommerce.dto.responseDto.CartResponseDto;
import com.example.FlipCommerce.dto.responseDto.OrderResponseDto;
import com.example.FlipCommerce.exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.exceptions.EmptyCartException;
import com.example.FlipCommerce.exceptions.InsufficientQuantityException;
import com.example.FlipCommerce.exceptions.InvalidCardException;
import com.example.FlipCommerce.models.Item;

public interface CartService {
    public CartResponseDto addToCart(Item item, ItemRequestDto itemRequestDto);

    public OrderResponseDto checkOutCart(CheckOutCartRequestDto checkOutCartRequestDto) throws CustomerNotFoundException, InvalidCardException, EmptyCartException, InsufficientQuantityException;
}
