package com.shamanthaka.assignment3;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("iPhone");
        treeSet.add("Cell Phone");
        treeSet.add("redme");
        treeSet.add("Bicycle");
        treeSet.add("Bicycle");

        //printing

        Iterator<String> iter = treeSet.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("*******************");

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());

        System.out.println("Sise is " + treeSet.size());

        treeSet.remove("Cell Phone");
        System.out.println("After removing Size is " + treeSet.size());

    }
}
