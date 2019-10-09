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
//        final char[] delimiters = { ' ', '_', '-' };
//        System.out.println(WordUtils.capitalizeFully(null, delimiters));
//        System.out.println(WordUtils.capitalizeFully("this_is-a test EXAMPLE", delimiters));
//        System.out.println(WordUtils.capitalizeFully("a", delimiters));
//        System.out.println(WordUtils.capitalizeFully("thor almighty", delimiters));
//        System.out.println(WordUtils.capitalizeFully("string operation", delimiters));
//        System.out.println(WordUtils.capitalizeFully("TITLE CASE CONVERSION", delimiters));

        SpringApplication.run(NetflixApplication.class, args);
    }

}
