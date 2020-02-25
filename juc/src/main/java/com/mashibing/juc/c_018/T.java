package com.mashibing.juc.c_018;


/**
 * String类型作为锁
 * 因为在JVM中具有String常量池(如果两个String具有相同的值，那么他们的地址是相同的，都保存在这个常量池中)。
 * 当以String作为锁的时候，如果值相同则，那么线程持有相同的锁。这样就造成了另外一个线程不能执行
 * Created by Administrator on 2020/1/21.
 */
public class T {
    private String s1 = "hello";
    private String s2 = "hello";

    void m1() {
        synchronized (s1) {

        }
    }

    void m2() {
        synchronized (s2) {

        }
    }

}
