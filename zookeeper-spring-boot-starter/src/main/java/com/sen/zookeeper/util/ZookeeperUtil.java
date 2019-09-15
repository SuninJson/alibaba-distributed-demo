package com.sen.zookeeper.util;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Huang Sen
 */
@Component
public class ZookeeperUtil {

    private final CuratorFramework curatorFramework;

    @Autowired
    public ZookeeperUtil(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
        this.curatorFramework.start();
    }

    public void createNode(String nodePath, String value) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().forPath(nodePath, value.getBytes());
    }

}
