package com.code.security.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApplication {
    public static void main( String[] args ) {
        SpringApplication.run(DemoApplication.class,args);
    }

  /*  @GetMapping
    public String hello(){
        return "hello spring security!";
    }*/
}
