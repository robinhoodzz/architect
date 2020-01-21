package com.mashibing.juc.c_004;

/**
 * synchronized关键字
 * 对某个对象加锁
 * Created by Administrator on 2020/1/21.
 */
public class T {

    private static int count = 10;

    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void n() {
        synchronized (T.class) {
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }
}
