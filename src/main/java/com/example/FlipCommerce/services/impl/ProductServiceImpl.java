package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.requestDto.ProductRequestDto;
import com.example.FlipCommerce.dto.responseDto.ProductResponseDto;
import com.example.FlipCommerce.exceptions.SellerNotFoundException;
import com.example.FlipCommerce.models.Product;
import com.example.FlipCommerce.models.Seller;
import com.example.FlipCommerce.repository.ProductRepository;
import com.example.FlipCommerce.repository.SellerRepository;
import com.example.FlipCommerce.services.ProductService;
import com.example.FlipCommerce.transformers.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

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

    @Override
    public List<ProductResponseDto> getProductByCategoryAndPrice(Category category, Integer price) {
        List<Product> products = productRepository.findByCategoryAndPrice(category, price);

        /*Product(entity) --> Dto*/
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product: products) {
            productResponseDtos.add(ProductTransformer.productToProductResponseDto(product));
        }
        return productResponseDtos;
    }

    @Override
    public Set<String> productPriceGreaterThan500() {
        Iterable<Product> productIterable = productRepository.findAll();
        Set<String> productSet = new HashSet<>();

        /*Iterate whole product table*/
        for (Product product: productIterable) {
            if (product.getPrice() > 500){
                productSet.add(product.getName());
            }

        }
        return productSet;
    }

    @Override
    public List<String> top5CostliestProduct() {
        return null;
    }

    @Override
    public List<String> top5CheapestProduct() {
        return null;
    }

    @Override
    public Set<String> productBasedOnSellerEmailId(String emailId) {
        return null;
    }

    @Override
    public Set<String> outOfStockProductForAParticularCategory(Category category) {
        return null;
    }

    @Override
    public void sendEmailToSellerProductOutOfStock() {

    }

    @Override
    public void deleteProduct(int id) {

    }
}
