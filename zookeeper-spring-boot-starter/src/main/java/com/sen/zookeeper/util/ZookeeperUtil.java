package com.sen.zookeeper.util;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Huang Sen
 */
public class ZookeeperUtil {

    private final CuratorFramework curatorFramework;

    public ZookeeperUtil(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
        this.curatorFramework.start();
    }

    public void createData(String nodePath, String dataValue) {
        try {
            curatorFramework.create().creatingParentsIfNeeded().forPath(nodePath, dataValue.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String nodePath) {
        try {
            curatorFramework.delete().withVersion(0).forPath(nodePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
