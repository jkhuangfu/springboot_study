package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.jk.dao") //扫描dao接口所在包同时将dao所有接口在工厂中创建对象
public class JkApplication {
  public static void main(String[] args) {
    System.out.println("args = " + args);
    SpringApplication.run(JkApplication.class, args);
  }

}
