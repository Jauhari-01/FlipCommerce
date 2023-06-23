package com.example.FlipCommerce.transformers;

import com.example.FlipCommerce.dto.responseDto.ItemResponseDto;
import com.example.FlipCommerce.models.Item;

public class ItemTransformer {
    public static Item itemRequestDtoToItem(int quantity){
        return Item.builder()
                .requiredQuantity(quantity)
                .build();
    }

    public static ItemResponseDto itemToItemResponseDto(Item item){
        return ItemResponseDto.builder()
                .quantityAdded(item.getRequiredQuantity())
                .price(item.getProduct().getPrice())
                .productName(item.getProduct().getName())
                .build();
    }
}
