package com.settle;

import com.settle.common.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@ImportResource(locations = {"classpath:ignite-client.xml"})
@SpringBootApplication
@MapperScan("com.settle.mapper")
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        SpringContextUtil.setApplicationContext(applicationContext);
    }


}
