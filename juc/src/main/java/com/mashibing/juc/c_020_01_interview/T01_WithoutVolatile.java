package com.mashibing.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题
 * 实现一个容器, 提供2个方法, add, size
 * 写两个线程, 线程1添加10个元素到容器中, 线程2实现监控元素的个数, 当个数到5个时, 线程2给出提示并结束
 * 分析下面的程序, 能完成这个功能吗?
 * 归结于2个线程之间相互通信的问题
 * Created by Administrator on 2020/2/25.
 */
public class T01_WithoutVolatile {

    List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T01_WithoutVolatile c = new T01_WithoutVolatile();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);


                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "t1").start();

        new Thread(()->{
            while (true) {
                if(c.size() ==5){
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();

    }

}
