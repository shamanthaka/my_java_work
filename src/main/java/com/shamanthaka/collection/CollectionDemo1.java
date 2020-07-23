package com.shamanthaka.collection;

import lombok.extern.log4j.Log4j;

import java.util.*;
@Log4j
public class CollectionDemo1 {
    public void listDemo(){


        List<String> stringList = new ArrayList<String>();
        stringList.add("tom");
        stringList.add("jerry");
        stringList.add("tim");
        stringList.add("mouse");
        log.info(stringList);
        //System.out.println(stringList);
        log.info(" "+stringList.size() );
        //System.out.println(stringList.size());
        //1 .enhanced for loop

        /*for(String str : stringList){
            System.out.println(str);
        }

        //2. array way

        for(int i = 0; i < stringList.size(); i++ ){
            System.out.println(stringList.get(i));
        }

        //3 iteration

        /* System.out.println(Arrays.deepToString(stringList.toArray())); */


        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            if (name.equals("tom")){
                iterator.remove();
            }
            //System.out.println(iterator.next());

        }

        ListIterator<String> listIterator = stringList.listIterator();
        while (listIterator.hasPrevious()){
           // System.out.println(listIterator.next());
        }

        for(String str : stringList){
            System.out.println(str);
        }

        //stringList.stream().forEach(str -> System.out.println(str));
        Collections.sort(stringList,Collections.reverseOrder());

        System.out.println(stringList);

        //stringList.stream().forEach(str -> System.out.println(str));
    }

    public static void main(String[] args) {
        CollectionDemo1 collectionDemo1 = new CollectionDemo1();
        collectionDemo1.listDemo();
    }
}
