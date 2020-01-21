package com.mashibing.juc.c_007;

/**
 * synchronized关键字
 * 对某个对象加锁
 * Created by Administrator on 2020/1/21.
 */
public class T {


    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();
    }

    private synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(7000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    private void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }


}
