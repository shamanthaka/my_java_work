package com.shamanthaka.assignment5;
import lombok.extern.log4j.Log4j;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


//https://www.codedplace.com/simple-crud-add-edit-delete-and-view-in-java-using-txttext-file-as-database/
@Log4j
public class FileCrud {

    private static final String FILE_NAME = "emp.txt";

    public void addRecord() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file,true);

        BufferedWriter bw = new BufferedWriter(writer);
        Scanner strInput = new Scanner(System.in);

        String id, name, city, salary;

        log.info("Enter the Employee ID: ");
        id = strInput.nextLine();
        System.out.print("Enter the Employee Name: ");
        name = strInput.nextLine();
        System.out.print("Enter the Employee City: ");
        city = strInput.nextLine();
        System.out.print("Enter the Employee Salary: ");
        salary = strInput.nextLine();

        bw.write(id+","+name+","+city+","+salary);
        bw.flush();
        bw.newLine();
        bw.close();
    }


    public void viewAllRecords() throws IOException {
        BufferedReader br = new BufferedReader( new FileReader(FILE_NAME) );

        String record;


        log.info("|	ID		Name 			City			Salary 		  ");

        while( ( record = br.readLine() ) != null ) {
            StringTokenizer st = new StringTokenizer(record,",");
            log.info("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      |");
        }

        br.close();
    }

    public void deleteRecordByID() throws IOException {
        Scanner strInput =  new Scanner(System.in);
        String id, record;

        File tempDB = new File("emp_temp.txt");
        if (!tempDB.exists()) {
            tempDB.createNewFile();
        }

        File db = new File(FILE_NAME);

        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );

        log.info("\t\t Delete Employee Record\n");

        log.info("Enter the Employee ID: ");
        id =  strInput.nextLine();

        while( ( record = br.readLine() ) != null ) {
            if( record.contains(id) ) {
                continue;
            }

            bw.write(record);
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();

        db.delete();

        tempDB.renameTo(db);
    }


    public void searchRecordbyID() throws IOException {
        String id,record;
        Scanner strInput = new Scanner(System.in);

        BufferedReader br = new BufferedReader( new FileReader(FILE_NAME) );
        log.info("\t Search Employee Record\n");

        log.info("Enter the Employee ID: ");
        id = strInput.nextLine();


        log.info("|	ID		Name 			City			Salary 		 ");

        while( ( record = br.readLine() ) != null ) {
            StringTokenizer st = new StringTokenizer(record,",");
            String id_ = st.nextToken();
            if( id_.contains(id) ) {
                log.info("|	"+id_+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      ");
            }
        }


        br.close();
    }

    public void menu(FileCrud fileCrud) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while(true) {
            log.info("1. Add Employee ");
            log.info("2. Query by employee id ");
            log.info("3. Delete an employee ");
            log.info("4. Display all Employee ");
            log.info("5. Exit ");
            log.info("Please Enter your Option: ");
            int option = scanner.nextInt();
            if (option == 1) {
                fileCrud.addRecord();
            } else if (option == 2) {
                fileCrud.searchRecordbyID();
            } else if (option == 3) {
                fileCrud.deleteRecordByID();
            } else if (option == 4) {
                fileCrud.viewAllRecords();
            } else if (option == 5) {
                break;
            } else {
                log.info("Enter correct option!");
            }
        }
    }


    public static void main(String[] args)  {
        try {
            FileCrud fileCrud = new FileCrud();
            fileCrud.menu(fileCrud);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
