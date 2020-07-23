package com.shamanthaka.mine;

import lombok.extern.log4j.Log4j;

@Log4j
public class MyThreadDemo2 implements Runnable {
    Thread thread ;

    public MyThreadDemo2(String threadName){
        thread = new Thread(threadName);
    }
    @Override
    public void run() {

       log.info(Thread.currentThread().getName());

    }


    public static void main(String[] args) {
        MyThreadDemo2 myThreadDemo2 = new MyThreadDemo2("threadName");

        Thread thread = new Thread(myThreadDemo2);
        thread.start();
        MyThreadDemo2 myThreadDemo = new MyThreadDemo2("threadName");
        Thread thread1 = new Thread(myThreadDemo);
        thread1.start();


        log.info(Thread.currentThread().getName());

    }


}
