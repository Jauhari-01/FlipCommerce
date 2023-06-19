package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.CardRequestDto;
import com.example.FlipCommerce.dto.responseDto.CardResponseDto;
import com.example.FlipCommerce.exceptions.CustomerNotFoundException;

public interface CardService {
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;

    String cardTypeMaxNumberOfTimes();

    String cardTypeMinNumberOfTimes();
}
