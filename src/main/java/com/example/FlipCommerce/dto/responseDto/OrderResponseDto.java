package com.example.FlipCommerce.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderResponseDto {
    String customerName;

    String orderNo;

    int totalValue;

    Date dateOfOrder;

    String cardUsed;

    List<ItemResponseDto> items;
}
