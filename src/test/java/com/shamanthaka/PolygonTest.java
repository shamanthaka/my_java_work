package com.shamanthaka;


import com.shamanthaka.assignment2.Polygon;
import com.shamanthaka.assignment2.Rectangle;
import com.shamanthaka.assignment2.Square;
import org.junit.Assert;
import org.junit.Test;

public class PolygonTest {
    @Test
    public void testSquare(){
        Polygon square = new Square(22f);
        square.calcArea();
        square.calcPeri();
        Assert.assertNotNull(square);
    }
    @Test
    public void testRectangle(){
        Polygon rectangle = new Rectangle(5.6f,7.8f);
        rectangle.calcArea();
        rectangle.calcPeri();
        Assert.assertNotNull(rectangle);
    }

}
