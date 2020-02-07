package com.mashibing.juc.c_018;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法, 使用AtomicXXX类
 * Atomic类本身方法都是原子性的, 但不能保证多个方法连续调用是原子性的
 * Created by Administrator on 2020/1/22.
 */
public class T01_AtomicInterget {

    AtomicInteger count = new AtomicInteger(0);

    private void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet(); // count++
        }
    }

    public static void main(String[] args) {
        T01_AtomicInterget t = new T01_AtomicInterget();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach(Thread::start);

        threads.forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
