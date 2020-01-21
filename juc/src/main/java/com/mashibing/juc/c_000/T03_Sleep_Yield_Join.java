package com.mashibing.juc.c_000;

/**
 * 睡眠
 * 屈服
 * 加入
 * Created by Administrator on 2020/1/21.
 */
public class T03_Sleep_Yield_Join {

    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }


    private static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A: " + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B: " + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();


    }

    private static void testJoin() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("A0: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }

}
