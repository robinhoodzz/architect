package com.mashibing.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.Collections;
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
public class T02_WithVolatile {
    /*
    即使添加volatile关键字, 也是有问题的
    因为添加的过程不是同步的, 多个线程添加元素时, 读到的size值, 很可能是旧数据, 造成脏读, 最终导致size值小于list里实际的元素值
    正确的写法应该是使用 Collections.synchronizedList(list的实现类)
     */

    // 添加volatile, 使t2能够得到通知
    volatile List<Object> list = new ArrayList<>();
    // volatile List<Object> list = Collections.synchronizedList(new ArrayList<>());


    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T02_WithVolatile c = new T02_WithVolatile();

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
