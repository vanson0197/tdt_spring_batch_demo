package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@EnableBatchProcessing
@ImportResource("classpath:batchjob.xml")
@SpringBootApplication
class BatchProcessingApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BatchProcessingApplication.class, args);
    }
}
