package com.mashibing.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2020/1/22.
 */
public class T05_ReentrantLock5 extends Thread {

    private static ReentrantLock lock = new ReentrantLock(true); // 谁等待长就让谁先执行

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock5 rl = new T05_ReentrantLock5();

        Thread th1 = new Thread(rl);
        Thread th2 = new Thread(rl);
        th1.start();
        th2.start();
    }
}
