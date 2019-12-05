package com.example.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhangliang
 * @date 2019/12/5 19:03
 */
public class WatcherDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final CountDownLatch countDownLatch=new CountDownLatch(1);
        final ZooKeeper zooKeeper=
                new ZooKeeper("192.168.182.128:2181,192.168.182.128:2181,192.168.182.128:2181",
                        4000, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("默认事件： "+event.getType());
                        if(Event.KeeperState.SyncConnected==event.getState()){
                            //如果收到了服务端的响应事件，连接成功
                            countDownLatch.countDown();
                        }
                    }
                });
        countDownLatch.await();

        zooKeeper.create("/zk-persis-zl","1".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);


        //exists  getdata getchildren
        //通过exists绑定事件
        Stat stat=zooKeeper.exists("/zk-persis-zl", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType()+"->"+event.getPath());
                try {
                    //再一次去绑定事件
                    zooKeeper.exists(event.getPath(),true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //通过修改的事务类型操作来触发监听事件
        stat=zooKeeper.setData("/zk-persis-zl","2".getBytes(),stat.getVersion());

        Thread.sleep(1000);

        zooKeeper.delete("/zk-persis-zl",stat.getVersion());

        System.in.read();
    }

}
