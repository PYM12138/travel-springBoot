package com.lenovo.travelspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan(basePackages = "com.lenovo.travelspringboot.web.servlet")
public class TravelSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelSpringBootApplication.class, args);
    }

}
