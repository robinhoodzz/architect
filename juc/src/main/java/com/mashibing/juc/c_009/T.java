package com.mashibing.juc.c_009;

import java.util.concurrent.TimeUnit;

/**
 * 可重入
 * 一个同步方法调用另一个同步方法, 一个线程已经拥有了某个线程的锁, 再次申请的时候仍然会得到该对象的锁
 * 也就是说 synchronized 获得的锁是可重入的
 * Created by Administrator on 2020/1/21.
 */
public class T {


    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m1, "t1").start();
    }

    private synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    private synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }


}
