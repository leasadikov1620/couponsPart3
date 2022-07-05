package com.lea.couponsPart2.beans;

public enum Categories {
    FOOD("FOOD"),
    ELECTRICITY("ELECTRICITY"),
    RESTAURANT("RESTAURANT"),
    VACATION("VACATION");
    private String name;
    Categories (String name){
        this.name=name;
    }
    private final int value = ordinal() + 1;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
//CHECK