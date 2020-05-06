package com.febs.febs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.febs.febs.*.mapper")
public class FebsApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FebsApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
