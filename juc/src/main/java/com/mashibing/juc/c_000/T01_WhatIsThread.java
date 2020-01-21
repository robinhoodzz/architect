package com.mashibing.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * 什么是线程
 * Created by Administrator on 2020/1/21.
 */
public class T01_WhatIsThread {
    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        // new T1().run(); // 这叫做方法调用, 这不是启动线程
        new T1().start(); // start方法
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main");
        }
    }
}
