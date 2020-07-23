package com.shamanthaka.assignment2;

import java.util.Date;

abstract public class Medicine {
    private float price;
    private Date expiryDate;

    public Medicine(float price, Date expiryDate){
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public void getDetails(){
        System.out.println(this.price+ ",  " + this.expiryDate);
    }
    public abstract void displayLabel();
}
