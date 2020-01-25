package com.mashibing.juc.c_020;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Created by Administrator on 2020/1/23.
 */
public class T11_TestSemaphore {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);

        new Thread(() -> {
            try {
                s.acquire(); // 阻塞方法
                System.out.println("T1 start...");
                Thread.sleep(200);
                System.out.println("T1 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();


        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T2 start...");
                Thread.sleep(200);
                System.out.println("T2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();


    }
}
