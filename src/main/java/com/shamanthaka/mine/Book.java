package com.shamanthaka.mine;

/*import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
*/
public class Book {

    private int bookNo;
    private String title;
    private String author;
    private float price;


    public void setBookNo(int bookNo){
        this.bookNo =  bookNo;  //rhs bookno is from set paraameter
    }
    public int getBookNo(){
        return this.bookNo;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
         return this.price;
    }

  /*
    public void setBookNo(int bookNo){
        this.bookNo = bookNo;
    }
    public int getBookNo(){ return  this.bookNo;}
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return this.price;
    }
    */
}
