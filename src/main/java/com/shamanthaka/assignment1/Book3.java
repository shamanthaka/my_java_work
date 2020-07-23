package com.shamanthaka.assignment1;

public class Book3 {

    private int bookNo;
    private String title;
    private String author;
    private float price;

    private String errorMsg = "";

    public Book3(int bno, String title, String author, float price){
        this.bookNo = bno;
        if(title == null || title.length() < 4){
            errorMsg = " title must be 4 characters";
        }
        this.title = title;
        this.author = author;
        if(price < 1 || price > 5000){
            errorMsg += " Price should be within 1 and 5000";
        }
        this.price = price;
        bookCount++;
    }

    private static int bookCount; //this is a class level variable or static variable

    static {
        bookCount = 0;
    }

    public static int getBookCount(){
        return  bookCount;
    }

    public String toString(){
        if( errorMsg.length() > 0){
            return errorMsg;
        }else {
            return this.bookNo + ", " + this.title + ", " + this.author + ", " + this.price;
        }
    }
}
