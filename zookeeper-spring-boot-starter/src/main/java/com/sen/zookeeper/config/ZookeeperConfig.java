package com.sen.zookeeper.config;

import com.sen.zookeeper.util.ZookeeperUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Huang Sen
 */
@SpringBootConfiguration
public class ZookeeperConfig {

    @Bean
    public ZookeeperProperties zookeeperProperties() {
        return new ZookeeperProperties();
    }

    @Bean
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.builder()
                .connectString(zookeeperProperties().getAddress())
                .retryPolicy(new ExponentialBackoffRetry(1000, 1000))
                .build();
    }

    @Bean
    public ZookeeperUtil zookeeperUtil() {
        return new ZookeeperUtil(curatorFramework());
    }


}
