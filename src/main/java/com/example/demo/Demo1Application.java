package com.example.demo;

import com.example.demo.entity.BanqueTest;
import com.example.demo.entity.Clients;
import com.example.demo.enumer.AccountType;
import com.example.demo.repositori.BanqueRepositori;
import com.example.demo.repositori.ClientRepositori;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Bean
    CommandLineRunner start(BanqueRepositori banqueRepositori, ClientRepositori ClientRepositori) {

        return args -> {

            Stream.of("kounet", "oumar", "diallo").forEach(c->{
                Clients clients = Clients.builder()
                        .name(c)
                        .build();
                ClientRepositori.save(clients);

            });
            ClientRepositori.findAll().forEach(clients -> {
                for (int i = 0; i < 10; i++) {
                    BanqueTest banqueTest = BanqueTest.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.courant : AccountType.epargne)
                            .balance(10000 + Math.random() + 90000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .clients(clients)
                            .build();
                    banqueRepositori.save(banqueTest);
                }

            });

        };
    }
}
