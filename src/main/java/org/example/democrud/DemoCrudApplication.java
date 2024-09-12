package org.example.democrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCrudApplication.class, args);
    }

}
