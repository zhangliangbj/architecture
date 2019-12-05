package com.example.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author zhangliang
 * @date 2019/12/5 21:24
 */
public class CuratorDemo {

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("192.168.182.128:2181,192.168.182.128:2181,192.168.182.128:2181")
                .sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator").build();

        curatorFramework.start();

        try {
            //结果：/curator/zl/node
            //原生API中，必须是逐层创建，也就是父节点必须存在，子节点才能创建
            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                    .forPath("/zl/node","1".getBytes());

            curatorFramework.delete().deletingChildrenIfNeeded().forPath("/zl/node");

            Stat stat=new Stat();
            curatorFramework.getData().storingStatIn(stat).forPath("/zl/node");

            curatorFramework.setData().
                    withVersion(stat.getVersion()).forPath("/zl/node","xx".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
