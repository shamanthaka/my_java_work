package com.shamanthaka.mine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Studentm {
    //int => Integer, long => Long

    private HashMap<Integer,String> names = new HashMap<>();

    public void setNames(){
        //[1,"venkat"], [2, "anitha"], [3,vinny], [4, srijan]
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter names to exit from while loop enter no");
            String name = sc.next();
            if(name.equals("no")){
                break;
            }
            System.out.println("Enter rollono ");
            int rollno = sc.nextInt();
            names.put(rollno, name);
        }
    }

    public void printNames(){
        Collection<String> nameCollection = names.values(); //["anitha", "venkat","vinny", "srijan"]
        for(String s: nameCollection){
            System.out.println(s);
        }
    }

    public void printNamesKeySet(){
        Set<Integer> keys = names.keySet();  //[20, 21,22,23]  ==> [srijan,anitha, venkat, vinni]
        for(Integer rno: keys){
            System.out.println(names.get(rno));
        }
    }

    public void getName(Integer key){
        String value = names.get(key);
        System.out.println("Corresponding name is " + value);
    }

    public void remove(Integer key){
        String value = names.remove(key);
        System.out.println("Removed name " + value);
    }

    public void printSize(){
        int size = names.size();
        System.out.println("Hashmap size is  " + size);
    }

    public static void main(String[] args) {
        Studentm student = new Studentm();
        student.setNames();
        student.printNames();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a rollnumber ");
        int rno = sc.nextInt();
        student.getName(rno);
        System.out.println("Enter a rollonumber to remove ");
        rno = sc.nextInt();
        student.remove(rno);
        student.printSize();
    }
}
