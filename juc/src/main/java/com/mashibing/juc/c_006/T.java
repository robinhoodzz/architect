package com.mashibing.juc.c_006;

/**
 * synchronized关键字
 * 对某个对象加锁
 * Created by Administrator on 2020/1/21.
 */
public class T implements Runnable {

    private int count = 100;

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }


}
