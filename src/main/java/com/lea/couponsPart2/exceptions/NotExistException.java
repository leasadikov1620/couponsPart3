package com.lea.couponsPart2.exceptions;

public class NotExistException extends Exception {
    public NotExistException(String message) {
        super(message);
    }

    public NotExistException(ExceptionType exceptionType) {
        super(exceptionType.toString() + " not found");
    }

}
