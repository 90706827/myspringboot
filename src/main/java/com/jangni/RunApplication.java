package com.jangni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = "com.jangni")
public class RunApplication {

    public static void main(String[] args){

        SpringApplication.run(RunApplication.class,args);

    }
}
