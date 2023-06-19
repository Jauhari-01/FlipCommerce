package com.example.FlipCommerce.dto.responseDto;

import com.example.FlipCommerce.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {
    String customerName;

    String cardNo;

    CardType cardType;
}
