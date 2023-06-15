package com.example.FlipCommerce.transformers;

import com.example.FlipCommerce.dto.requestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.responseDto.SellerResponseDto;
import com.example.FlipCommerce.models.Seller;

public class SellerTransformer {
    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller
                .builder()
                .name(sellerRequestDto.getName())
                .mobNo(sellerRequestDto.getMobNo())
                .emailId(sellerRequestDto.getEmailId())
                .build();
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){

        return SellerResponseDto
                .builder()
                .name(seller.getName())
                .emailId(seller.getEmailId())
                .build();
    }
}
