package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.ItemRequestDto;
import com.example.FlipCommerce.exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.exceptions.InsufficientQuantityException;
import com.example.FlipCommerce.exceptions.OutOfStockException;
import com.example.FlipCommerce.exceptions.ProductNotFoundException;
import com.example.FlipCommerce.models.Item;

public interface ItemService {
    public Item createItem(ItemRequestDto itemRequestDto) throws ProductNotFoundException, CustomerNotFoundException, InsufficientQuantityException, OutOfStockException;
}
