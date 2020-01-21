package com.mashibing.juc.c_000;

/**
 * 创建线程
 * Created by Administrator on 2020/1/21.
 */
public class T02_HowToCreateThread {

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> System.out.println("Hello Lambda!")).start(); // 别忘了调用start方法
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello Thread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello Runnable!");
        }
    }
}
