package com.example.FlipCommerce.transformers;

import com.example.FlipCommerce.dto.responseDto.ItemResponseDto;
import com.example.FlipCommerce.dto.responseDto.OrderResponseDto;
import com.example.FlipCommerce.models.Customer;
import com.example.FlipCommerce.models.Item;
import com.example.FlipCommerce.models.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {
    public static OrderEntity orderRequestDtoToOrderEntity(Item item, Customer customer){
        return OrderEntity.builder()
                .orderNo(String.valueOf(UUID.randomUUID()))
                .totalValue(item.getRequiredQuantity() * item.getProduct().getPrice())
                .customer(customer)
                .items(new ArrayList<>())
                .build();
    }

    public static OrderResponseDto orderToOrderResponseDto(OrderEntity orderEntity){
        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for (Item item : orderEntity.getItems()) {
            itemResponseDtoList.add(ItemTransformer.itemToItemResponseDto(item));
        }

        return OrderResponseDto.builder()
                .customerName(orderEntity.getCustomer().getName())
                .orderNo(orderEntity.getOrderNo())
                .totalValue(orderEntity.getTotalValue())
                .dateOfOrder(orderEntity.getDateOfOrder())
                .cardUsed(orderEntity.getCardUsed())
                .items(itemResponseDtoList)
                .build();
    }
}