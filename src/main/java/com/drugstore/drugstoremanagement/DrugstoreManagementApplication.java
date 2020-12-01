package com.drugstore.drugstoremanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class DrugstoreManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugstoreManagementApplication.class, args);
    }

}
