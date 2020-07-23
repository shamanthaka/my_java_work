package com.shamanthaka.mine;

public class BookDetails3 {

    public static void main(String[] args) {
        Book3 o1 = new Book3(145, "My Java", " james", 10.98f);
        Book3 o2 = new Book3(145, "My Java", " james", 10.98f);

        System.out.println("Object instance count " + Book3.getBookCount());
    }
}
