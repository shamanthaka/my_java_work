package com.shamanthaka.mine;

import lombok.extern.log4j.Log4j;

@Log4j
public class MyThreadDemo1 extends Thread {


    @Override
    public void run() {
        log.info(Thread.currentThread().getName());
    }

    public MyThreadDemo1(String threadName) {
        super(threadName);


    }

    public static void main(String[] args) {
        log.info(Thread.currentThread().getName());
        MyThreadDemo1 myThreadDemo1 = new MyThreadDemo1("Thread1");
        MyThreadDemo1 myThreadDemo11 = new MyThreadDemo1("Thread2");
        myThreadDemo1.start();
        myThreadDemo11.start();
    }
}
