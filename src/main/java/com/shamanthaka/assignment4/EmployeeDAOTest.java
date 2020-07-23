package com.shamanthaka.assignment4;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.util.Scanner;

@Log4j
public class EmployeeDAOTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = MySqlDBConnection.getDBConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        while(true){
            log.info("1. Add Record ");
            log.info("2. Show All Records ");
            log.info("3. Delete Record ");
            log.info("4. Query an Employee ");
            log.info("5. Update an Employee ");
            log.info("6. Exit ");
            log.info("Enter above option: ");
            int option = scanner.nextInt();
            if(option == 1){
                log.info("Enter employee id: ");
                int empId = scanner.nextInt();
                scanner.nextLine();
                log.info("Enter employee name: ");
                String empName = scanner.nextLine();
                log.info("Enter employee city: ");
                String empCity = scanner.nextLine();
                log.info("Enter employee salary: ");
                double empSalary = scanner.nextDouble();

                employeeDAO.addEmployee(empId, empName, empCity, empSalary);
            }else if(option == 2){
                log.info("Show All Records");
                employeeDAO.display();
            }else if(option == 3){
                log.info("Enter a employee ID to delete record: ");
                int empId = scanner.nextInt();
                employeeDAO.deleteEmployee(empId);
            }else if(option == 4){
                log.info("Enter a employee ID to query: ");
                int empId = scanner.nextInt();
                employeeDAO.queryByEmployee(empId);
            }else if(option == 5){
                log.info("Enter employee id: ");
                int empId = scanner.nextInt();
                scanner.nextLine();
                log.info("Enter employee name: ");
                String empName = scanner.nextLine();
                log.info("Enter employee city: ");
                String empCity = scanner.nextLine();
                log.info("Enter employee salary: ");
                double empSalary = scanner.nextDouble();
                employeeDAO.updateEmployee(empId, empName, empCity, empSalary);
            }else if(option == 6){
                break;
            }else{
                log.info("Enter correct option!");
            }

        }
    }
}
