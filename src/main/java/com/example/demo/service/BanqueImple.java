package com.example.demo.service;

import com.example.demo.DTO.BanqueRequestDTO;
import com.example.demo.DTO.BanqueResponseDTO;
import com.example.demo.entity.BanqueTest;
import com.example.demo.repositori.BanqueRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class BanqueImple implements BanqueImp{
    @Autowired
    private BanqueRepositori banqueRepositori;
    @Override
    public BanqueResponseDTO addcomptes(BanqueRequestDTO banqueDTO) {

        BanqueTest banqueTest = BanqueTest.builder()
                .id(UUID.randomUUID().toString())
                .type(banqueDTO.getType())
                .balance(banqueDTO.getBalance())
                .createdAt(new Date())
                .currency(banqueDTO.getCurrency())
                .build();
        BanqueTest saveBank = banqueRepositori.save(banqueTest);
        BanqueResponseDTO banqueResponseDTO  = BanqueResponseDTO.builder()
                .id(saveBank.getId())
                .type(saveBank.getType())
                .balance(saveBank.getBalance())
                .createdAt(saveBank.getCreatedAt())
                .currency(saveBank.getCurrency())
                .build();

        return banqueResponseDTO;
    }
    @Override
    public BanqueResponseDTO update(String id, BanqueRequestDTO banqueDTO) {

        BanqueTest banqueTest = BanqueTest.builder()
                .id(id)
                .type(banqueDTO.getType())
                .balance(banqueDTO.getBalance())
                .createdAt(new Date())
                .currency(banqueDTO.getCurrency())
                .build();
        BanqueTest saveBank = banqueRepositori.save(banqueTest);
        BanqueResponseDTO banqueResponseDTO  = BanqueResponseDTO.builder()
                .id(saveBank.getId())
                .type(saveBank.getType())
                .balance(saveBank.getBalance())
                .createdAt(saveBank.getCreatedAt())
                .currency(saveBank.getCurrency())
                .build();

        return banqueResponseDTO;
    }
}
