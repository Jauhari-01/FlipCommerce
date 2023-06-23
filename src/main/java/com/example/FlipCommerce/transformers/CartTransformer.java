package com.example.FlipCommerce.transformers;

import com.example.FlipCommerce.dto.responseDto.CartResponseDto;
import com.example.FlipCommerce.dto.responseDto.ItemResponseDto;
import com.example.FlipCommerce.models.Cart;
import com.example.FlipCommerce.models.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {
    public static CartResponseDto cartToCartResponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        for (Item item : cart.getItems()) {
            itemResponseDtos.add(ItemTransformer.itemToItemResponseDto(item));

        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtos)
                .build();
    }
}
