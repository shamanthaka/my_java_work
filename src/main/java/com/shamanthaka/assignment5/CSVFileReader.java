package com.shamanthaka.assignment5;

import com.shamanthaka.assignment4.MySqlDBConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CSVFileReader {

    public void csvReader(String file) throws FileNotFoundException {

        File fileObj = new File(file);

        Scanner scanner = new Scanner(fileObj);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println("un parsed data");

            System.out.println("parsed data");

            if(str != null && str.length() > 0){
                String[] data = str.split(","); //parsing

                int empId = new Integer(data[0].trim());
                String empName = data[1].trim();
                String empCity = data[2].trim();
                double empSal = new Double(data[3].trim());

                addEmployee(empId, empName, empCity, empSal);

                System.out.println(empId);
                System.out.println(empName);
                System.out.println(empSal);
                /*for(String c: data){
                    System.out.println(c);
                }*/
            }

        }
    }


    public void addEmployee(int empId, String empName, String empCity, double salary){
        String sqlInsert = "insert into employee (emp_id, emp_name, emp_city, emp_salary, emp_doj) values(?, ?, ?, ?, ?)";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            connection.setAutoCommit(false); //transaction starts
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setInt(1, empId);
            ps.setString(2, empName);
            ps.setString(3, empCity);
            ps.setDouble(4, salary);
            ps.setDate(5, new Date(new java.util.Date().getTime()));
            ps.execute();
            connection.commit(); //transaction ends
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CSVFileReader csvFileReader = new CSVFileReader();
        try {
            csvFileReader.csvReader("my_data.csv");
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }
}
