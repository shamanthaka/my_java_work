package com.shamanthaka.assignment1;

public class Book2  {
    private int bookNo;
    private String title;
    private String author;
    private float price;

    private String errorMsg = "";

    public Book2(){}

    public Book2(int bookNo,String title,String author, float price){
        this.bookNo = bookNo;
        if(title == null || title.length() < 4){
            errorMsg = "Title must be 4 characters ";
        }
        this.title = title;
        this.author = author;
        if(price < 1 || price > 5000){
            errorMsg += " Price shoud be within 1 and 5000";
        }
        this.price = price;
    }

    /*public int getBookNo(){
        return this.bookNo;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public float getPrice(){
        return this.price;
    }*/

    public String toString(){ //toString() this is Object (class) method
        if( errorMsg.length() > 0){
            return errorMsg;
        }else {
            return this.bookNo + ", " + this.title + ", " + this.author + ", " + this.price;
        }
    }
}
