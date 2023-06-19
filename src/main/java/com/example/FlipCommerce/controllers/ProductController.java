package com.example.FlipCommerce.controllers;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.requestDto.ProductRequestDto;
import com.example.FlipCommerce.dto.responseDto.ProductResponseDto;
import com.example.FlipCommerce.exceptions.SellerNotFoundException;
import com.example.FlipCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        try{
            ProductResponseDto productResponseDto = productService.addProduct(productRequestDto);
            return new ResponseEntity<>(productResponseDto, HttpStatus.valueOf(201));
        }catch (SellerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-product/category/{category}/price/{price}")
    public ResponseEntity<List<ProductResponseDto>> getProductByCategoryAndPrice(@PathVariable("category") Category category, @PathVariable("price") Integer price){
        List<ProductResponseDto> productResponseDto = productService.getProductByCategoryAndPrice(category, price);
        return new ResponseEntity<>(productResponseDto, HttpStatus.FOUND);
    }

    /* Get all the products in a category who have price greater than 500 */
    @GetMapping("/product-price-greater-than-500")
    public ResponseEntity<Set<String>> productPriceGreaterThan500(){
        Set<String> list = productService.productPriceGreaterThan500();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Get top 5 costliest products in a category */
    @GetMapping("/top-5-costliest-product")
    public ResponseEntity<List<String>> top5CostliestProduct(){
        List<String> list = productService.top5CostliestProduct();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Get the top 5 cheapest products in a category */
    @GetMapping("/top-5-cheapest-product")
    public ResponseEntity<List<String>> top5CheapestProduct(){
        List<String> list = productService.top5CheapestProduct();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Get all the products of seller based on email id */
    @GetMapping("/product-based-on-seller-emailId")
    public ResponseEntity<Set<String>> productBasedOnSellerEmailId(@RequestParam String emailId){
        Set<String> productSet = productService.productBasedOnSellerEmailId(emailId);
        return new ResponseEntity<>(productSet, HttpStatus.FOUND);
    }

    /* Get all the out-of-stock products for a particular category */
    @GetMapping("/out-of-stock-products-for-a-particular-category/{category}")
    public ResponseEntity<Set<String>> outOfStockProductForAParticularCategory(@PathVariable Category category){
        Set<String> list = productService.outOfStockProductForAParticularCategory(category);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    /* Send an email to the seller of the product if the product is out of stock. */
    @GetMapping("/send-email-to-seller-product-out-of-stock")
    public ResponseEntity<String> sendEmailToSellerProductOutOfStock(){
        productService.sendEmailToSellerProductOutOfStock();
        return new ResponseEntity<>("Email send to the seller successfully.", HttpStatus.FOUND);
    }

    /*Delete product*/
    @DeleteMapping("/delete-product")
    public ResponseEntity<String> deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
    }
}
