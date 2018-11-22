package com.ports.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ports.demo.dao")
@EnableScheduling
public class DemoApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);
    }
}
