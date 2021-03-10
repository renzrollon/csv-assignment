package com.zuhlke.assignment;

import com.zuhlke.assignment.service.DbEvolveService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner dbEvolver(DbEvolveService dbEvolveService) {
        return args -> dbEvolveService.initDatabase();
    }
}
