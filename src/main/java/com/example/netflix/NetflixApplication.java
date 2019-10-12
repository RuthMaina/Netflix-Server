package com.example.netflix;

import lombok.Data;
import lombok.extern.java.Log;
import org.apache.commons.text.WordUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NetflixApplication {

    public static void main(String[] args) {

        SpringApplication.run(NetflixApplication.class, args);
    }

}
