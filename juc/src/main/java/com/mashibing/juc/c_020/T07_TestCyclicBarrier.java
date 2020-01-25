package com.mashibing.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 * 发令枪
 * Created by Administrator on 2020/1/22.
 */
public class T07_TestCyclicBarrier {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(20, ()-> System.out.println("人满, 发车"));

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
