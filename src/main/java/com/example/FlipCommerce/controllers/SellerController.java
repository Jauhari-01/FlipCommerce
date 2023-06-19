package com.example.FlipCommerce.controllers;

import com.example.FlipCommerce.dto.requestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.responseDto.SellerResponseDto;
import com.example.FlipCommerce.exceptions.SellerNotFoundException;
import com.example.FlipCommerce.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add-seller")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        SellerResponseDto sellerResponseDto = sellerService.addSeller(sellerRequestDto);
        return new ResponseEntity(sellerResponseDto ,HttpStatus.CREATED);
    }

    /* Update the seller info based on email. */
    @PutMapping("/update-seller-name-mobileNo")
    public ResponseEntity<String> updateSellerInfo(@RequestParam String emailId, @RequestParam String name, String mobNo){
        try{
            sellerService.updateSellerInfo(emailId, name, mobNo);
            return new ResponseEntity<>("Seller information updated successfully.", HttpStatus.CREATED);
        }catch (SellerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /* Get all the sellers who sell products of a particular category */
    @GetMapping("/sellers-sell-products-of-a-particular-category/{category}")
    public ResponseEntity<List<String>> sellersSellProductsOfAParticularCategory(@PathVariable String category){
        List<String> list = sellerService.sellersSellProductsOfAParticularCategory(category);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Get all the products sold by a seller in a category */
    @GetMapping("/product-sold-by-seller-in-a-particular-category/{category}")
    public ResponseEntity<List<String>> productSoldBySellerInAParticularCategory(@PathVariable String category){
        List<String> list = sellerService.productSoldBySellerInAParticularCategory(category);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Seller with maximum number of products */
    @GetMapping("/seller-with-maximum-product")
    public ResponseEntity<List<String>> sellerMaxProduct(){
        List<String> name = sellerService.sellerMaxProduct();
        return new ResponseEntity<>(name, HttpStatus.FOUND);
    }

    /* Seller with minimum number of products */
    @GetMapping("/seller-with-minimum-product")
    public ResponseEntity<List<String>> sellerMinProduct(){
        List<String> name = sellerService.sellerMinProduct();
        return new ResponseEntity<>(name, HttpStatus.FOUND);
    }

    /* Seller(s) selling the costliest product */
    @GetMapping("/seller-costliest-product")
    public ResponseEntity<Set<String>> sellerCostliestProduct(){
        Set<String> list = sellerService.sellerCostliestProduct();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Seller(s) selling the cheapest product */
    @GetMapping("/seller-cheapest-product")
    public ResponseEntity<Set<String>> sellerCheapestProduct(){
        Set<String> set = sellerService.sellerCheapestProduct();
        return new ResponseEntity<>(set, HttpStatus.FOUND);
    }
}
