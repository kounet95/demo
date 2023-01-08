package com.example.demo.repositori;

import com.example.demo.entity.BanqueTest;
import com.example.demo.enumer.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BanqueRepositori extends JpaRepository<BanqueTest, String> {


    List<BanqueTest> findByType(AccountType type);
}
