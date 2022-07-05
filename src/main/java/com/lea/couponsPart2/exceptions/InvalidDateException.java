package com.lea.couponsPart2.exceptions;

public class InvalidDateException extends Exception{

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(ExceptionType exceptionType) {
        super(exceptionType.toString() + " has invalid date values!");
    }
}
