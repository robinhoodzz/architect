package com.mashibing.juc.c_003;

/**
 * synchronized关键字
 * 对某个对象加锁
 * Created by Administrator on 2020/1/21.
 */
public class T {

    private int count = 10;

    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }
}
