package com.redandblue.redandblueservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RedAndBlueServiceApplication {

    public static void main(String[] args) {
        log.info("SERVICE STARTING.....");
        SpringApplication.run(RedAndBlueServiceApplication.class, args);
        log.info("SERVICE START.....SUCCESS");

    }

}
