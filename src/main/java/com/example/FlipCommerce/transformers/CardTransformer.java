package com.example.FlipCommerce.transformers;

import com.example.FlipCommerce.dto.requestDto.CardRequestDto;
import com.example.FlipCommerce.dto.responseDto.CardResponseDto;
import com.example.FlipCommerce.models.Card;

public class CardTransformer {
    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .validTill(cardRequestDto.getValidTill())
                .build();
    }

    public static CardResponseDto cardToCardResponseDto(Card card){
        return CardResponseDto.builder()
                .customerName(card.getCustomer().getName())
                .cardNo(card.getCardNo())
                .cardType(card.getCardType())
                .build();
    }
}
