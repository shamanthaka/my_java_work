package com.shamanthaka.mine;

import java.util.Date;
import java.util.Random;

public class TestMedicine {
    public static void main(String[] args) {

        /*Medicine[] medicines = {
                new Tablet(2.99f, new Date(),"store in cool and dry place"),
                new Syrup(2.99f, new Date(),"use it according to the prescription"),
                new Ointment(2.99f, new Date(), "external use only")
        };

        Random random = new Random();
        for (int i = 0; i < 5; i++){
            int r = random.nextInt(3);
            medicines[r].displayLabel();
        } */

        Medicine[] medicines = {
                new Tablet(3.99f, new Date(), "store in cool and dry place"),
                new Syrup(2.99f, new Date(),"use it according to the prescription"),
                new Ointment(2.99f, new Date(),"external use only")

        };
        Random random = new Random();
        for (int i = 0; i< 5; i++){
            int r = random.nextInt(3);

        }

    }

}
