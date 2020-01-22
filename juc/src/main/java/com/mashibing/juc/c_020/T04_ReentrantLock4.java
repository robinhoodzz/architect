package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock用于替代synchronized
 * 本例中由于m1锁定this, 只有m1执行完毕的时候, m2才能执行
 * 这里是复习synchronized最原始的语义
 * <p>
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是, 必须要手动释放锁
 * 使用sync锁定的话, 如果遇到异常, jvm会自动释放锁, 但是lock必须手动释放锁, 因此经常在finally代码块里释放
 * <p>
 * 使用reentrantlock可以进行"尝试锁定" tryLock, 这样无法锁定或在指定时间内无法锁定
 * <p>
 * 使用ReentrantLock还可以调用lockInterruptibly方法, 可以对线程interrupt方法做出处理
 * 在一个线程等待锁的过程中, 可以被打断
 * Created by Administrator on 2020/1/22.
 */
public class T04_ReentrantLock4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
//                lock.lock();
                lock.lockInterruptibly(); // 可以对interrupt()方法做出响应, 区别在于t2被打断后, lock()进入catch块处理, lockInterruptibly()进入finally处理
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt(); // 打断t2线程的等待
    }

}
