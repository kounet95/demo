package com.example.demo.repositori;

import com.example.demo.entity.BanqueTest;
import com.example.demo.entity.Clients;
import com.example.demo.enumer.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface ClientRepositori extends JpaRepository<Clients, Long> {


}
