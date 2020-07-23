package com.shamanthaka.mine;

import java.util.Date;

public class Tablet extends Medicine {
    String label;
    public Tablet(float price, Date expiryDate, String label){
        super(price,expiryDate);
        this.label = label;
    }

    public void displayLabel(){
        System.out.println(this.label);
    }
}
