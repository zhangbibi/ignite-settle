package com.settle;

import com.settle.client.ClientNode;
import com.settle.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@ImportResource(locations = {"classpath:ignite-cluster.xml"})
@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        SpringContextUtil.setApplicationContext(applicationContext);

        ClientNode clientNode = (ClientNode) applicationContext.getBean("clientNode");
        clientNode.start();
    }


}
