package com.chen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author chenyingtao
 * @Date 2023/7/24 13:15
 */
@SpringBootApplication
@MapperScan("com.chen.dao")
public class serverApplication {
    public static void main(String[] args) {
        SpringApplication.run(serverApplication.class);
    }
}
