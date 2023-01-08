package com.example.demo.DTO;

import com.example.demo.enumer.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BanqueRequestDTO {
    private double balance;
    private String currency;
    private AccountType type;
}
