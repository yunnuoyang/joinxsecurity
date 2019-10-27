package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2//自动生成文档
public class HelloWorld {
   public static void main(String[] args) {
      SpringApplication.run(HelloWorld.class,args);
   }
   @GetMapping("/hello")
   private String hello(){
      return "hello,world!";
   }
}
