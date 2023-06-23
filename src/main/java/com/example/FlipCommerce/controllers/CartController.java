package com.example.FlipCommerce.controllers;

import com.example.FlipCommerce.dto.requestDto.CheckOutCartRequestDto;
import com.example.FlipCommerce.dto.requestDto.ItemRequestDto;
import com.example.FlipCommerce.dto.responseDto.CartResponseDto;
import com.example.FlipCommerce.dto.responseDto.OrderResponseDto;
import com.example.FlipCommerce.models.Item;
import com.example.FlipCommerce.services.CartService;
import com.example.FlipCommerce.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @PostMapping("/add-cart")
    public ResponseEntity<Object> addCard(@RequestBody ItemRequestDto itemRequestDto){
        try{
            /*Create the item*/
            Item item = itemService.createItem(itemRequestDto);

            /*Add created item to cart*/
            CartResponseDto cartResponseDto = cartService.addToCart(item, itemRequestDto);
            return new ResponseEntity<>(cartResponseDto, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*Check out the item from the cart*/
    @PostMapping("/checkout-cart")
    public ResponseEntity<Object> checkOutCart(@RequestBody CheckOutCartRequestDto checkOutCartRequestDto){
        try {
            OrderResponseDto orderResponseDto = cartService.checkOutCart(checkOutCartRequestDto);
            return new ResponseEntity<>(orderResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
