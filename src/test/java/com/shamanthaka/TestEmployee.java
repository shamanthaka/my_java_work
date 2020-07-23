package com.shamanthaka;

import com.shamanthaka.assignment2.Employee;
import org.junit.Assert;
import org.junit.Test;

public class TestEmployee {
    @Test
    public void shallowTest(){
        Employee e1 = new Employee("james", 34);
        Employee e2 = new Employee("james", 34);

        if(e1.equals(e2)){
            System.out.println("Objects are equal");
        }else{
            System.out.println("Objects are not equal");
        }

        Assert.assertEquals(e1,e2);

    }

}
