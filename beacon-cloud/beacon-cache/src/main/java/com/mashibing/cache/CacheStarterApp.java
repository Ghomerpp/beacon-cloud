package com.mashibing.cache;

import org.redisson.RedissonLock;
import org.redisson.client.RedisClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zjw
 * @description
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.msb.framework.redis",
        "com.mashibing.cache"
})
@EnableDiscoveryClient
public class CacheStarterApp {

    public static void main(String[] args) {
        SpringApplication.run(CacheStarterApp.class,args);
    }

}
