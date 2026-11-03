package com.newage.consultancy.exception;

public class MethodArgumentNotValidException extends RuntimeException{

    public MethodArgumentNotValidException(String msg){
        super(msg);
    }
}
