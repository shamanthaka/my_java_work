package mine;

import com.shamanthaka.mine.Book;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    @Test
    public static void main(String [] args){
        Book[] book = new Book[3];
        for(int i = 0; i< book.length;i++){
            book[i] = new Book();
            book[i].setTitle("title"+i);
            book[i].setAuthor("james"+i);
            book[i].setPrice(567.89f);
            book[i].setBookNo(345+i);

        }
        Assert.assertNotNull(book);
        Assert.assertEquals(3,book.length);
        Assert.assertNotNull(book[0].getTitle());
        Assert.assertNotNull(book[1].getTitle());
        Assert.assertNotNull(book[2].getTitle());

        Assert.assertEquals(3,book.length);
        Assert.assertNotNull(book[0].getAuthor());
        Assert.assertNotNull(book[1].getAuthor());
        Assert.assertNotNull(book[2].getAuthor());

        Assert.assertEquals(3,book.length);
        Assert.assertNotNull(book[0].getPrice());
        Assert.assertNotNull(book[1].getPrice());
        Assert.assertNotNull(book[2].getPrice());

        Assert.assertEquals(3,book.length);
        Assert.assertNotNull(book[0].getBookNo());
        Assert.assertNotNull(book[1].getBookNo());
        Assert.assertNotNull(book[2].getBookNo());

    }

    @Test
    public void testSearchBookArray(){
        Book book[] = new Book[4];
        for(int i =0; i< book.length; i++){
            book[i] = new Book();
            book[i].setTitle("title"+i);
            book[i].setAuthor("james"+i);
            book[i].setBookNo(i);
        }
        Book searchBook = new Book();
        searchBook.setBookNo(3);

        Assert.assertNotNull(book);
        Assert.assertEquals(searchBook.getBookNo(),book[3].getBookNo());

    }

}

