package com.anand.spring.transactions.exceptions;

public class InSufficientAmountException extends RuntimeException{

    public InSufficientAmountException(String msg){
        super(msg);

    }
}
