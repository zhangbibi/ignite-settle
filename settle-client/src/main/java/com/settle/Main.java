package com.settle;

import com.settle.client.ClientNode;
import com.settle.util.ClientSpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@ImportResource(locations = {"classpath:ignite-client.xml"})
@SpringBootApplication
//@MapperScan("com.settle.mapper")
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        ClientSpringContextUtil.setApplicationContext(applicationContext);

        ClientNode clientNode = (ClientNode) applicationContext.getBean("clientNode");
        clientNode.start();
    }


}
