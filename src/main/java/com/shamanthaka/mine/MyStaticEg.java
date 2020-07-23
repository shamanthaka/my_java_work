package com.shamanthaka.mine;

public class MyStaticEg {

    private static int count;

    public MyStaticEg(){
        //count = count + 1;
        count++;
    }

    //static block is for only static variables
    static {
        count = 0;
    }
    public static  int getCount(){
        return count;
    }

    public static void main(String[] args) {
        MyStaticEg o1 = new MyStaticEg();//r.hs.this is constructor, we are calling constructor
        MyStaticEg o2 = new MyStaticEg();
        MyStaticEg o3 = new MyStaticEg();

        /*System.out.println("Object Instance count is " + o1.getCount());
        System.out.println("Object Instance count is " + o2.getCount());
        System.out.println("Object Instance count is " + o3.getCount());*/
        System.out.println("Object Instance count is " + MyStaticEg.getCount());
    }
}
