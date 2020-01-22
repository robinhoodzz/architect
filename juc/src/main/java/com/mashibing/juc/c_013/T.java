package com.mashibing.juc.c_013;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile 并不能保证多个线程共同修改running变量时, 所带来的不一致问题, 也就是volatile不能替代synchronized
 * Created by Administrator on 2020/1/21.
 */
public class T {

    /*
    m方法自增1万次
    10个线程
    总计: count应该自增10万次
    但是结果却不是如此, 原因如下:
    1. 虽然使用了volatile关键字, 保证线程执行完自增并写入内存时,被其他线程看到
    2. 但是当A线程把值从0增加到1并写入时, 有B,C,D等N多线程看到值是1, 并使用了1这个值, 在这个基础上进行自增值变成2, 然后这些线程再写入回来值为2, 相当于少加了N次
    3. 只保证了可见性, 不能保证原子性
     */

    private volatile int count = 0;

    private void m() {
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
