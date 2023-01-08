package com.example.demo;

import com.example.demo.entity.BanqueTest;
import com.example.demo.enumer.AccountType;
import com.example.demo.repositori.BanqueRepositori;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Bean
    CommandLineRunner start(BanqueRepositori banqueRepositori) {

        return args -> {
            for (int i = 0; i < 10; i++) {
                BanqueTest banqueTest = BanqueTest.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random() > 0.5 ? AccountType.courant : AccountType.epargne)
                        .balance(10000 + Math.random() + 90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                banqueRepositori.save(banqueTest);
            }
        };
    }
}
