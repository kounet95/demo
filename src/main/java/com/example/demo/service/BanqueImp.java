package com.example.demo.service;

import com.example.demo.DTO.BanqueDTO;
import com.example.demo.DTO.BanqueRequestDTO;
import com.example.demo.DTO.BanqueResponseDTO;
import com.example.demo.entity.BanqueTest;

public interface BanqueImp {
    public BanqueResponseDTO addcomptes(BanqueRequestDTO banqueDTO);

    BanqueResponseDTO update(String id, BanqueRequestDTO banqueDTO);
}
