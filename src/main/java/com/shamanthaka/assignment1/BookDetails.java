package com.shamanthaka.assignment1;

import java.util.Scanner;

public class BookDetails {
    public static void main(String[] args){
        Book book = new Book();

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter bookno ");
        int bno = scanner.nextInt();
        book.setBookNo(bno);

        System.out.println("Enter Title");
        String title = scanner.next();
        book.setTitle(title);

        System.out.println(" Enter author ");
        String author = scanner.next();
        book.setAuthor(author);

        System.out.println("Enter price ");
        float price = scanner.nextFloat();
        book.setPrice(price);


        System.out.println("Book details ");

        System.out.println(book.getBookNo() + " ," + book.getTitle() + " ," + book.getAuthor() + ", " + book.getPrice());

    }
}
