package com.mashibing.juc.c_017;


import java.util.concurrent.TimeUnit;

/**
 * 锁定某个对象,如果o的属性发生改变, 不影响锁的使用
 * 但是如果o变成另一个对象, 则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外的对象
 * Created by Administrator on 2020/1/21.
 */
public class T {

    private /* final */ Object o = new Object();

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object(); // 所对象发生改变, 所以t2线程得以执行, 如果注释掉这句话, 线程2将永远得不到执行机会

        t2.start();
    }

    private void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

}
