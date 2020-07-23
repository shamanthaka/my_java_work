package com.shamanthaka;

import com.shamanthaka.assignment2.Employee2;
import junit.framework.Assert;
import org.junit.Test;

public class TestEmployee2 {
    @Test
    public void deepCompareTest(){
        Employee2 emp = new Employee2("james",321);
        Employee2 emp2 = new Employee2("james", 321);
        Assert.assertEquals(emp,emp2);
    }

    @Test
    public void empIdHashCodeTest(){
        Employee2 employee = new Employee2("james",453);
        int hashcode = employee.hashCode();
        System.out.println(hashcode);
        Assert.assertNotNull(employee);

    }
}
