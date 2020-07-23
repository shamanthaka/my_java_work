package com.shamanthaka.mine;

import java.util.Scanner;

public class BookDetails {

    public static void main(String[] args) {
        Book book = new Book();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter booknumber");
        int bookno = sc.nextInt();
        book.setBookNo(bookno);

        System.out.println("Enter title");
        String title = sc.next();
        book.setTitle(title);

        System.out.print("Enter author");
        String author = sc.next();
        book.setAuthor(author);

        System.out.print("set price");
        float price = sc.nextFloat();
        book.setPrice(price);
    }






    /*
    public static void main(String[] args){
        Book book = new Book();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter bookno");
        int bno = sc.nextInt();
        book.setBookNo(bno);

        System.out.println("Enter title");
        String title1 = sc.next();
        book.setTitle(title1);

        System.out.println("Enter author");
        String authorname = sc.next();
        book.setAuthor(authorname);

        System.out.println("Enter price");
        float price = sc.nextFloat();
        book.setPrice(price);


        System.out.println("Book details ");
        System.out.println(book.getBookNo()+ " ," + book.getTitle() + ", " + book.getAuthor() + "," +book.getPrice());
    }
    */
}
