package com.lea.couponsPart2.exceptions;


import com.lea.couponsPart2.beans.ClientType;

public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(ClientType clientType) {
        super("Invalid login " + clientType.toString());
    }

}
