package com.shamanthaka.mine;

public class BookDetails2 {
    public static void main(String[] args) {

        Book2 book2 = new Book2(1234, "the java", "James", 56.7f);
        System.out.println(book2);
        Book2 book = new Book2(156,"the computer", "charles", 567.8f);
        System.out.println( " object book instance count " + Book2.getBookCount());

    }
}
