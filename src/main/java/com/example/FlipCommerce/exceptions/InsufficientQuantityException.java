package com.example.FlipCommerce.exceptions;

public class InsufficientQuantityException extends Exception{
    public  InsufficientQuantityException(String message){
        super(message);
    }
}
