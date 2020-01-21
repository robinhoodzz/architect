package com.mashibing.juc.c_001;

/**
 * synchronized关键字
 * 对某个对象加锁
 * Created by Administrator on 2020/1/21.
 */
public class T {

    private int count = 10;
    private final Object o = new Object();

    public void m() {
        synchronized (o) { // 任何线程要执行下面代码, 必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }
}
