package com.adsh.mongodbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestMongodbTestApplication {

    @Bean
    @ServiceConnection
    MongoDBContainer mongoDbContainer() {
        return new MongoDBContainer("mongo:latest");
    }

    public static void main(String[] args) {
        SpringApplication.from(MongodbTestApplication::main).with(TestMongodbTestApplication.class).run(args);
    }

}
