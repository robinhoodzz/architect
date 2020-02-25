package com.msb.zookeeper.lock;

import com.msb.zookeeper.config.ZKUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2020/2/17.
 */
@Slf4j
public class TestLock {

    private ZooKeeper zk;


    @Before
    public void setUp() throws Exception {
        zk = ZKUtils.getZK();
    }

    @After
    public void tearDown() throws Exception {
        zk.close();
    }

    @Test
    public void testLock() throws Exception {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                WatchCallBack watctCallBack = new WatchCallBack();
                watctCallBack.setZk(zk);
                String threadName = Thread.currentThread().getName();
                watctCallBack.setThreadName(threadName);

                watctCallBack.tryLock();

                log.info("{} is on workding...", threadName);

                watctCallBack.releaseLock();

            });
            thread.start();
            thread.join();
        }
    }
}
