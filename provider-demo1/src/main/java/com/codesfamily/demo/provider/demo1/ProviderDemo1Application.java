package com.codesfamily.demo.provider.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.codesfamily.demo")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.codesfamily.demo")
public class ProviderDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDemo1Application.class, args);
    }

}
