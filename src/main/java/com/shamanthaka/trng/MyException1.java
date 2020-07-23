package com.shamanthaka.trng;

public class MyException1 extends Exception{
    String message;
    public MyException1(String message) {
        super(message);
        this.message = message;
    }

}
