package com.sen.zookeeper.config;

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

    private final ZookeeperProperties properties;

    @Autowired
    public ZookeeperConfig(ZookeeperProperties properties) {
        this.properties = properties;
    }

    @Bean
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.builder()
                .connectString(properties.getAddress())
                .retryPolicy(new ExponentialBackoffRetry(1000, 1000))
                .build();
    }
}
