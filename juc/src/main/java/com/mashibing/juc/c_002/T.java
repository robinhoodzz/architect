package com.mashibing.juc.c_002;

/**
 * synchronized关键字
 * 对某个对象加锁
 * Created by Administrator on 2020/1/21.
 */
public class T {

    private int count = 10;

    public void m() {
        synchronized (this) { // 任何线程要执行下面代码, 必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }
}
