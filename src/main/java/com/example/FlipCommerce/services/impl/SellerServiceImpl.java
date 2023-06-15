package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.dto.requestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.responseDto.SellerResponseDto;
import com.example.FlipCommerce.models.Seller;
import com.example.FlipCommerce.repository.SellerRepository;
import com.example.FlipCommerce.services.SellerService;
import com.example.FlipCommerce.transformers.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {
        //Dto to entity
        Seller seller = SellerTransformer.sellerRequestDtoToSeller(sellerRequestDto);

        //saving into databas
        Seller savedSeller  = sellerRepository.save(seller);

        //Entity to Dto
        return SellerTransformer.sellerToSellerResponseDto(savedSeller);
    }
}
