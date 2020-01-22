package com.mashibing.juc.c_020;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时计数器
 * Created by Administrator on 2020/1/22.
 */
public class T06_TestCountDownLatch extends Thread {

    public static void main(String[] args) {
        usingJoin();
        usingCountDownLatch();
    }

    private static void usingJoin() {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
                latch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            latch.await(); // 注意写成 wait方法了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end countDownLatch");
    }
}
