package com.offcn;

import com.offcn.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppStartOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppStartOrder.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}