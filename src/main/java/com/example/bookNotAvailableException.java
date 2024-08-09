package com.example;

public class bookNotAvailableException extends Exception{
    public bookNotAvailableException(String message){
        super(message);
    }
}
