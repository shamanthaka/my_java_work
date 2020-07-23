package com.shamanthaka.mine;

public class Book2 {

    private int bookNo;
    private String title;
    private String author;
    private float price;

    private  static int bookCount;

    static {
         bookCount = 0;
    }

    public Book2(){}

    public static int getBookCount(){
        return bookCount;
    }
    String errorMsg ="";

    public Book2(int bookNo, String title, String author, float price){
        this.bookNo = bookNo;
        if(title == null || title.length() < 4){
            errorMsg = " Title must be 4 characters";
        }
        this.title = title;
        if(price < 1 || price > 5000){
            errorMsg += "The price must be within 1 and 5000";
        }
        this.author = author;
        this.price = price;

        bookCount++;
    }

    public String toString(){
        if(errorMsg.length() > 0){
            return errorMsg;
        }else {
            return this.bookNo + " ,"+ this.title + " ,"+ this.author + ","+this.price;
        }
    }

/*
    String errorMsg ="";

    Book2(int bookNo,String title, String author, float price){
        this.bookNo = bookNo;
        if(title == null || title.length() < 4){
            errorMsg = "Title must be 4 characters";
        }
        this.title = title;
        this.author = author;
        if(price < 0 || price > 5000){
            errorMsg += "The price range must be within 1 and 500";
        }
        this.price = price;

    }

    public String toString(){
        if(errorMsg.length() > 0){
            return errorMsg;
        } else{
            return this.bookNo + " ," + this.title + " ," + this.author + ", " + this.price;
        }

    }

*/

   /* private String errorMsg = "";

    public Book2(int bno,String title, String author,float price){
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
    }

    public String toString(){
        if (errorMsg.length() >0){
            return errorMsg;
        }else{
            return this.bookNo + ", " + this.title + ", " + this.author + ", "+ this.price;
        }
    }
    */

}
