package com.mashibing.cache;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //注册到 Nacos，让其他模块能通过服务名找到它。
public class CacheStarterApp {

    public static void main(String[] args) {
        SpringApplication.run(CacheStarterApp.class, args);
    }
}
