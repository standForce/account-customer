package com.transaction.accountcustomer.error;

public class ErrorMessage extends Exception {

    public ErrorMessage(String message, Throwable error) {
        super(message, error);
    }

}
