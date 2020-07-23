package com.shamanthaka.assignment2;

import java.util.Date;
import java.util.Random;

public class TestMedicine {
    public static void main(String[] args) {

        Medicine[] medicine = {
                new Tablet(2.99f, new Date(), "Store in coool and dry place"),
                new Syrup(2.99f, new Date(), "Use it according to prescription"),
                new Ointment(2.99f, new Date(), "External use only")
        };

        Random random = new Random();

        for(int i = 0; i < 5; i++){
            int r = random.nextInt(3);
            medicine[r].displayLabel();
        }
    }
}
