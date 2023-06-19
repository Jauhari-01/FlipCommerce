package com.example.FlipCommerce.services;

import com.example.FlipCommerce.dto.requestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.responseDto.SellerResponseDto;
import com.example.FlipCommerce.exceptions.SellerNotFoundException;

import java.util.List;
import java.util.Set;
public interface SellerService {
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto);

    void updateSellerInfo(String emailId, String name, String mobNo) throws SellerNotFoundException;
    List<String> sellersSellProductsOfAParticularCategory(String category);

    List<String> productSoldBySellerInAParticularCategory(String category);

    List<String> sellerMaxProduct();

    List<String> sellerMinProduct();

    Set<String> sellerCostliestProduct();

    Set<String> sellerCheapestProduct();
}
