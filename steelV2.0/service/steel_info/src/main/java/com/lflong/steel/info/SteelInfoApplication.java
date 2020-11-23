package com.lflong.steel.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.lflong.steel")
@MapperScan("com.lflong.steel.info.mapper")
public class SteelInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteelInfoApplication.class, args);
    }
}
