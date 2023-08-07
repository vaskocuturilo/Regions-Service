package com.regions.simpleregions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SimpleRegionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRegionsApplication.class, args);
    }

}
