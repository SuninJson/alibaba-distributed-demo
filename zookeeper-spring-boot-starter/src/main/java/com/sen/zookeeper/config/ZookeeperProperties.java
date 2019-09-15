package com.sen.zookeeper.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Huang Sen
 */
@Data
@Component
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {

    @Value("address")
    private String address;
}


