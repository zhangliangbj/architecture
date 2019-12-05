package com.example.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhangliang
 * @date 2019/12/5 18:18
 */
public class ConnectionDemo {

    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper = new ZooKeeper("192.168.182.128:2181,192.168.182.128:2181,192.168.182.128:2181",
                    4000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (Event.KeeperState.SyncConnected==watchedEvent.getState()){
                        //如果收到了服务端的响应事件，连接成功
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());

            //添加节点
            zooKeeper.create("/zk-persis-zl","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Thread.sleep(1000);
            Stat stat = new Stat();
            //得到当前节点的值
            byte[] bytes = zooKeeper.getData("/zk-persis-zl",null,stat);
            System.out.println(new String(bytes));
            //修改节点值
            zooKeeper.setData("/zk-persis-zl","1".getBytes(),stat.getVersion());

            //得到当前节点的值
            byte[] bytes1 = zooKeeper.getData("/zk-persis-zl",null,stat);
            System.out.println(new String(bytes1));

            zooKeeper.delete("/zk-persis-zl",stat.getVersion());

            zooKeeper.close();
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


}


