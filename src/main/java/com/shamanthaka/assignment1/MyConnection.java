package com.shamanthaka.assignment1;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class MyConnection {
    private static Connection connection;
    public static Connection getConnection(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/new_employee_db",
                    "root","root");

        } catch(Exception ex){
            log.error("error in db connection " +ex.getMessage());
        }

        return connection;
    }

}
