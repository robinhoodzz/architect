package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2020/2/25.
 */
public class T13_TestLockSupport {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

                if(i == 5) {
                    LockSupport.park();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        LockSupport.unpark(t); // 先执行解封, 会解封整个线程的阻塞, 可以先于park前调用, wait前调用notify是无用的

        try {
            TimeUnit.SECONDS.sleep(8);

        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("after 8 seconds!");

        LockSupport.unpark(t);

    }
}
