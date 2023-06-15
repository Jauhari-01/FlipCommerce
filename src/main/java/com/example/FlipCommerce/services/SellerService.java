package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.responseDto.SellerResponseDto;
import org.springframework.stereotype.Service;


public interface SellerService {
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto);
}
