package com.anand.spring.transactions.util;

import com.anand.spring.transactions.exceptions.InSufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentValidationUtil {

    private static Map<String,Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1",2000.0);
        paymentMap.put("acc2",1000.0);
        paymentMap.put("acc3",3000.0);
        paymentMap.put("acc4",4000.0);
    }

    public static boolean validateCreditLimit(String accNo,double amount){
        System.out.println("Account:"+accNo+"Amount:"+amount);
        if(amount>paymentMap.get(accNo)){
            throw new InSufficientAmountException("InSufficient Amount in the Account");
        }else{
            return true;
        }


    }
}
