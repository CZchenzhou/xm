package com.xm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.xm.mapper")
@SpringBootApplication
public class XmApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmApplication.class, args);
    }
}
