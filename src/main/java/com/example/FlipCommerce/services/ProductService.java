package com.example.FlipCommerce.services;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.requestDto.ProductRequestDto;
import com.example.FlipCommerce.dto.responseDto.ProductResponseDto;
import com.example.FlipCommerce.exceptions.SellerNotFoundException;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;

    List<ProductResponseDto> getProductByCategoryAndPrice(Category category, Integer price);

    Set<String> productPriceGreaterThan500();

    List<String> top5CostliestProduct();

    List<String> top5CheapestProduct();

    Set<String> productBasedOnSellerEmailId(String emailId);

    Set<String> outOfStockProductForAParticularCategory(Category category);

    void sendEmailToSellerProductOutOfStock();

    void deleteProduct(int id);
}
