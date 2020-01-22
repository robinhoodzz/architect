package com.mashibing.juc.c_016;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 优化
 * 同步代码块中的语句 越少越好
 * 比较m1 与 m2
 * Created by Administrator on 2020/1/21.
 */
public class FineCoarseLock {

    private int count = 0;

    private synchronized void m1() {
        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;

        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void m2() {
        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 业务逻辑中只有下面这句需要sync, 这时不应该给整个方法上锁
        // 采用细粒度的锁, 可以使线程竞争时间变短, 从而提高效率
        synchronized (this) {
            count++;
        }

        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
