package com.shamanthaka.assignment1;

public class BookDetails3 {

    public static void main(String[] args) {
        Book3 o1 = new Book3(123, "My Java", "James", 10.99f);
        Book3 o2 = new Book3(123, "My Java", "James", 10.99f);

        System.out.println("Object instance count " + Book3.getBookCount());
    }
}
