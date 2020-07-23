package com.shamanthaka.trng;

public class EmpTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        try {
            employee.setName("james");
            employee.setAge(20);
        } catch (MyException1 myException1) {
            myException1.printStackTrace();
        }

        System.out.println(employee);
    }
}
