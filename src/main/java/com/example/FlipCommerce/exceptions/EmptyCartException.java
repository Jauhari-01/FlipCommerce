package com.example.FlipCommerce.exceptions;

public class EmptyCartException extends Exception{
    public EmptyCartException(String message){
        super(message);
    }
}
