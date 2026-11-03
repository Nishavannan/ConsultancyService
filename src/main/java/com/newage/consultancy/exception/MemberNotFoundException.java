package com.newage.consultancy.exception;

public class MemberNotFoundException extends RuntimeException{

    public  MemberNotFoundException(String msg){
        super(msg);
    }
}
