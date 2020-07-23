package mine;

import com.shamanthaka.mine.EngineeringBook;
import org.junit.Assert;
import org.junit.Test;

public class EngineerigBookTest {
    @Test
    public void testEngineerBook(){
        EngineeringBook engineerigBook = new EngineeringBook();
        engineerigBook.setCategory("Computer Science");
        engineerigBook.setTitle("The java");
        engineerigBook.setBookNo(345);
        engineerigBook.setPrice(321.7f);

        Assert.assertNotNull(engineerigBook);
        Assert.assertEquals("Computer Science",engineerigBook.getCategory());
    }
}
