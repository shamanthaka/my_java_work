package com.shamanthaka;

import com.shamanthaka.assignment1.Book;
import junit.framework.Assert;
import org.junit.Test;


public class BookTest {
    /*@Test
    public void bookTest1(){
        Book book = new Book();
        book.setBookNo(134);
        book.setTitle("Java");
        book.setAuthor("James");
        book.setPrice(789.4f);
        Assert.assertNotNull(book);
        Assert.assertEquals(134,book.getBookNo());//static method
        Assert.assertNotNull(book.getTitle());
        //log.info("Hello");
    }
*/
    @Test
    public void testBookArray(){
        Book book[] = new Book[3];
        for(int i = 0; i< book.length; i++){
            book[i] = new Book();
            book[i].setTitle("title"+i);
            book[i].setAuthor("james"+i);
            book[i].setPrice(456.78f);
            book[i].setBookNo(345+i);
        }
        Assert.assertNotNull(book);
        Assert.assertEquals(3,book.length);
        Assert.assertNotNull(book[0].getTitle());
        Assert.assertNotNull(book[1].getTitle());
        Assert.assertNotNull(book[2].getTitle());

    }

    @Test
    public void testSearchBookArray(){
        Book book[] = new Book[4];
        //int bookNumber = 100;
        for(int i = 0; i< book.length; i++){
            book[i] = new Book();
            book[i].setTitle("title"+i);
            book[i].setAuthor("james"+i);
            book[i].setPrice(456.78f);
            book[i].setBookNo(i);
        }

        Book searchBook = new Book();
        searchBook.setBookNo(3);


        Assert.assertNotNull(book);
        Assert.assertEquals(searchBook.getBookNo(),book[3].getBookNo());
    }


}
