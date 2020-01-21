package com.mashibing.juc.c_010;

import java.util.concurrent.TimeUnit;

/**
 * 可重入
 * 一个同步方法调用另一个同步方法, 一个线程已经拥有了某个线程的锁, 再次申请的时候仍然会得到该对象的锁
 * 也就是说 synchronized 获得的锁是可重入的
 * Created by Administrator on 2020/1/21.
 */
public class T {


    public static void main(String[] args) {
        new TT().m();
    }

    public synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }


}

class TT extends T {
    @Override
    public synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
