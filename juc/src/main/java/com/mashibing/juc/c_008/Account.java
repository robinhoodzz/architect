package com.mashibing.juc.c_008;

import java.util.concurrent.TimeUnit;

/**
 * 面试题: 模拟银行账户
 * 对业务写方法枷锁
 * 对业务读方法不加锁
 * 这样行不行
 *
 * Created by Administrator on 2020/1/21.
 */
public class Account {

    private String name;
    private double balance;

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(() -> a.set("zhangsan", 100.00D)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

    }

    private synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    private/*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

}
