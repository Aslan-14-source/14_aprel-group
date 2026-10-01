package com.educore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.educore")
@EntityScan(basePackages = "com.educore.entity")
@EnableJpaRepositories(basePackages = "com.educore.repository")
public class EduCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduCoreApplication.class, args);
    }
}