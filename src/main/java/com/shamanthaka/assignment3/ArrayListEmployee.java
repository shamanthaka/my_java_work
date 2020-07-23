package com.shamanthaka.assignment3;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Log4j
public class ArrayListEmployee {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        Employee e = new Employee("abby",20);
        list.add(e);
        list.add(new Employee("james", 34));
        list.add(new Employee("anna",56));
        list.add(new Employee("lilly",51));
        list.add(new Employee("lola",44));
        System.out.println("without sorting");
        list.stream().forEach(employee -> {
            log.info(employee.getName() + "  \t" +employee.getAge());
        });

        //log.info(list);
        //Collections.sort(list);
        Collections.sort(list, Employee.compareByAge);
        System.out.println("sorting by age");
        list.stream().forEach(employee -> {
            log.info(employee.getName() + "  \t" +employee.getAge());
        });

        System.out.println("sorting by name");
        Collections.sort(list, Employee.compareByName);
        list.stream().forEach(employee -> {
            log.info(employee.getName() + "  \t" +employee.getAge());
        });


    }
}
