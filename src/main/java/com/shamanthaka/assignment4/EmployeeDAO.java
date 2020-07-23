package com.shamanthaka.assignment4;

import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.Calendar;
@Log4j
public class EmployeeDAO { //DAO ==> Data Access Object

    //fetching records ==> getting records from the database
    public void display(){
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from employee");
            while(rs.next()){
                log.info(rs.getInt("emp_id"));
                log.info(rs.getString("emp_name"));
                log.info(rs.getString("emp_city"));
                log.info(rs.getString("emp_salary"));
                log.info(rs.getString("emp_doj"));
                log.info("********************************");
            }
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    //query by employee id,  fetching records ==> getting records from the database
    public void queryByEmployee(int empId){
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where emp_id = ?");
            preparedStatement.setInt(1, empId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("emp_id"));
                System.out.println(rs.getString("emp_name"));
                System.out.println(rs.getString("emp_city"));
                System.out.println(rs.getString("emp_salary"));
                System.out.println(rs.getString("emp_doj"));
            }
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    //inserting records
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

    private Date getJoingDate(int empId){
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where emp_id = ?");
            preparedStatement.setInt(1, empId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getDate("emp_doj");
            }
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return null;
    }

    //updating records
    public void updateEmployee(int id, String empName, String empCity, double salary){

        String sqlUpdate = "update employee set emp_name = ?, emp_city = ?, emp_salary = ?, emp_doj = ? where emp_id = ?";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {

            connection.setAutoCommit(false);
            Date empDoj = getJoingDate(id); //fetching doj and updating the records
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1,empName);
            preparedStatement.setString(2, empCity);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setDate(4, empDoj);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            connection.commit();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    //deleting records
    public void deleteEmployee(int id){
        String sqlDelete = "delete from employee where emp_id = ?";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
