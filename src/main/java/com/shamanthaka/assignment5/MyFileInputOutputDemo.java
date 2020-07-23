package com.shamanthaka.assignment5;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.util.Scanner;
@Log4j
public class MyFileInputOutputDemo {

    private static final String FILE_NAME = "vinny.txt";

    public void writeFile(String str) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            log.info(file.exists());
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(str.getBytes() );

            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile(){
        try {
            File file = new File(FILE_NAME);

            FileInputStream fileInputStream = new FileInputStream(file);

            byte b[] = new byte[fileInputStream.available()];

            fileInputStream.read(b);
            String content = new String(b);

            log.info(content);
            //log.info(b.toString());
            fileInputStream.close();
        } catch (IOException ex){
            //log.error(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        MyFileInputOutputDemo fileDemo1 = new MyFileInputOutputDemo();

        System.out.println("Enter a name to store in a file  ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.nextLine();
        fileDemo1.writeFile(input + "\n");

        fileDemo1.readFile();
    }
}
