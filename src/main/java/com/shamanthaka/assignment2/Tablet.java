package com.shamanthaka.assignment2;

import java.util.Date;

public class Tablet  extends  Medicine{
    private String label;

    public Tablet(float price, Date expiryDate,String label){
        super(price,expiryDate);//calling Medicine constructor
        this.label = label;
    }

    public void displayLabel(){
        System.out.println(this.label);
    }
}
