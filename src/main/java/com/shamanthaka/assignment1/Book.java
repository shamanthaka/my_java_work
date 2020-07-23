package com.shamanthaka.assignment1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int bookNo;
    private String title;
    private String author;
    private float price;
    private String errorMsg = "";

    public Book(){}

    private static int bookCount; //this is a class level variable or static variable

    static {
        bookCount = 0;
    }

    public static int getBookCount(){
        return  bookCount;
    }


    public Book(int bookNo,String title,String author, float price) {
        this.bookNo = bookNo;
        if (title == null || title.length() < 4) {
            errorMsg = "Title must be 4 characters ";
        }
        this.title = title;
        this.author = author;
        if (price < 1 || price > 5000) {
            errorMsg += " Price shoud be within 1 and 5000";
        }
        this.price = price;

        bookCount++;
    }
}

