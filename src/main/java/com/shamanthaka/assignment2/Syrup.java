package com.shamanthaka.assignment2;

import java.util.Date;

public class Syrup extends Medicine {

    private String label;

    public Syrup(float price, Date expiryDate, String label){
        super(price,expiryDate);
        this.label = label;
    }

    public void displayLabel(){
        System.out.println(this.label);
    }

}
