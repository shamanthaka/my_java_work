package com.shamanthaka.mine;

public class Book3 {

    private int bookNo;
    private String title;
    private String author;
    private float price;

    private String errorMsg= "";

    private static int bookCount;


    static {
        bookCount = 0;
    }

    public static int getBookCount(){
        return bookCount;
    }

    public Book3(int bno, String title, String author, float price){
        this.bookNo = bno;
        if(title == null || title.length() < 4){
            errorMsg = " tile must be 4 characters";
        }
        this.title = title;
        this.author = author;
        if(price < 1 || price > 5000){
            errorMsg += "Price should be within range of 1 and 5000";
        }
        this.price = price;

        bookCount++;
    }

    public String toString(){
        if( errorMsg.length() > 0){
            return errorMsg;
        }else {
            return this.bookNo + ", " + this.title + ", " + this.author + ", " + this.price;
        }
    }
}

