package com.lea.couponsPart2.exceptions;

public class TokenException extends Exception {
    public TokenException() {
        super("Token Exception");
    }

    public TokenException(String message) {
        super(message);
    }

}
