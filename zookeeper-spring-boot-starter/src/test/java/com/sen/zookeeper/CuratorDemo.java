package com.sen.zookeeper;

import com.sen.zookeeper.config.ZookeeperConfig;
import com.sen.zookeeper.util.ZookeeperUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Use Curator to operate Zookeeper
 *
 * @author Huang Sen
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CuratorDemo {

    @Autowired
    private ZookeeperUtil zookeeperUtil;

    @Before
    public void init() {
    }

    @Test
    public void createNode() {
        try {
            zookeeperUtil.createNode("/curatorDemo/node1","helloCurator");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
