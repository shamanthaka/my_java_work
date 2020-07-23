package com.shamanthaka.assignment4;

import com.shamanthaka.assignment1.MyConnection;
import lombok.extern.log4j.Log4j;

import java.sql.*;

@Log4j
public class JdbcDemo1 {
    Connection connection;
    public JdbcDemo1() {
        connection = MyConnection.getConnection();
    }

    public static void main(String[] args){
        JdbcDemo1 jdbcDemo1 = new JdbcDemo1();
        //jdbcDemo1.addEmp();
        jdbcDemo1.getAllEmp();
    }

    public void addEmp(){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?)");
            preparedStatement.setInt(1,19);
            preparedStatement.setString(2,"Suman");
            preparedStatement.setString(3, "My city");
            preparedStatement.setDouble(4,2435d);
            preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));

            int status = preparedStatement.executeUpdate();

            log.info("record inserted" + status);
        }catch(Exception ex){
            log.info(ex.getMessage());
        }
    }

    public void getAllEmp(){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("select * from employee");

            while(resultSet.next()){
                log.info(resultSet.getInt(1)+ ","+resultSet.getString(2)+","+resultSet.getString(3)+","+
                        resultSet.getDouble(4) +","+resultSet.getDate(5));
            }

        }catch (Exception ex){
            log.error(ex.getMessage());

        }
    }

}
