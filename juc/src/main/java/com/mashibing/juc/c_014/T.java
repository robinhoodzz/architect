package com.mashibing.juc.c_014;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile 并不能保证多个线程共同修改running变量时, 所带来的不一致问题, 也就是volatile不能替代synchronized
 * Created by Administrator on 2020/1/21.
 */
public class T {



    private  int count = 0;

    private synchronized void m() {
        for (int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        T t = new T();

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
