package com.shamanthaka.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
    private static Connection connection;

    public static Connection getDBConnection(){
        try{
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/new_employee_db","root","root");
            return connection;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
