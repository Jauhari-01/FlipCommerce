package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.dto.requestDto.ProductRequestDto;
import com.example.FlipCommerce.dto.responseDto.ProductResponseDto;
import com.example.FlipCommerce.exceptions.SellerNotFoundException;
import com.example.FlipCommerce.models.Product;
import com.example.FlipCommerce.models.Seller;
import com.example.FlipCommerce.repository.SellerRepository;
import com.example.FlipCommerce.services.ProductService;
import com.example.FlipCommerce.transformers.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller = sellerRepository.findByEmailId(productRequestDto.getSellerEmailId());

        if(seller == null){
            throw new SellerNotFoundException("EmailId is not registered.");
        }

        /*Dto --> Product(entity)*/
        Product savedProduct = ProductTransformer.productRequestDtoToProduct(productRequestDto);

        /*Update the product list*/
        seller.getProductList().add(savedProduct);

        savedProduct.setSeller(seller);

        /*Saved into database*/
        Seller savedSeller = sellerRepository.save(seller); /*Saved product and seller both*/

        /*Product(entity) --> Dto*/

        //entity to dto
        return  ProductTransformer.productToProductResponseDto(savedProduct);
    }
}
