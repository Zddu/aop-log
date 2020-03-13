package com.cidp.aoplog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.cidp.aoplog.mapper")
public class AopLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLogApplication.class, args);
    }

}
