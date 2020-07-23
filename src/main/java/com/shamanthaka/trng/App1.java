package com.shamanthaka.trng;

public class App1 {
    public static void main(String[] args) {

        try {
            String str = null;
            System.out.println(str.getBytes());
            System.out.println("hello");
            System.out.println("hello");
            System.out.println("hello");
            System.out.println("hello");
            System.out.println("hello");
        } catch (NullPointerException ex) {
            System.out.println("NUll value ");
            ex.printStackTrace();
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Not null value ");
            ex.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
    }
}
