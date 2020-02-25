package com.msb.zookeeper.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2020/2/17.
 */
@Slf4j
public class WatchCallBack implements AsyncCallback.StringCallback, AsyncCallback.Children2Callback, AsyncCallback.StatCallback, Watcher {


    String pathName;
    private ZooKeeper zk;
    private String threadName;
    private CountDownLatch cc = new CountDownLatch(1);

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public void tryLock() {
        try {
            log.info("{} is created", threadName);

            zk.create("/lock", threadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, this, "abc");

            cc.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void releaseLock() {

        try {
            zk.delete(pathName, -1);
            log.info("{} over work...", threadName);
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }

    }

    /**
     * zk.create
     */
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        if (name != null) {
            log.info("{} create node: {}", threadName, name);
            pathName = name;
            zk.getChildren("/", false, this, "def");
        }
    }

    /**
     * zk.getChildren
     */
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {

        Collections.sort(children);

        int i = children.indexOf(pathName.substring(1)); // 因为pathName带着"/", 而children中不带"/"

        if (i == 0) {
            log.info("{} is the first to get lock");

            try {
                zk.setData("/", threadName.getBytes(), -1);
                cc.countDown();
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            zk.exists("/" + children.get(i - 1), this, this, "ghi");
        }

    }


    /**
     * zk.exists
     */
    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                zk.getChildren("/", false, this, "jkl");
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
        }
    }

    /**
     * zk.exists
     */
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {

    }


}
