package com.mashibing.juc.c_018;


/**
 * String类型作为锁
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
