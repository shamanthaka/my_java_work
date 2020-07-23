package com.shamanthaka;

import com.shamanthaka.assignment1.EngineeringBook;
import org.junit.Assert;
import org.junit.Test;

public class EngineeringBookTest {
    @Test
    public  void testEngineeringBook(){
        EngineeringBook engineeringBook = new EngineeringBook();
        engineeringBook.setCategory("computer science");
        engineeringBook.setTitle("The java");
        engineeringBook.setAuthor("James");
        engineeringBook.setBookNo(345);
        engineeringBook.setPrice(321.9f);

        Assert.assertNotNull(engineeringBook);
        Assert.assertEquals("computer science",engineeringBook.getCategory());

    }

}
