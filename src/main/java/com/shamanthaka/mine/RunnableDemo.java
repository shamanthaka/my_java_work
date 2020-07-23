package com.shamanthaka.mine;

public class RunnableDemo implements Runnable {
    private Thread thread;
    private String threadName;

    RunnableDemo(String threadName){
        this.threadName = threadName;
        System.out.println("creating " + this.threadName);
    }

    public void run(){
        System.out.println("Running" + this.threadName);

    }
}
