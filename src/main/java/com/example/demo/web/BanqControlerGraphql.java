package com.example.demo.web;


import com.example.demo.DTO.BanqueDTO;
import com.example.demo.DTO.BanqueRequestDTO;
import com.example.demo.DTO.BanqueResponseDTO;
import com.example.demo.entity.BanqueTest;
import com.example.demo.repositori.BanqueRepositori;
import com.example.demo.service.BanqueImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BanqControlerGraphql {
@Autowired
    private BanqueRepositori banqueRepositori;
@Autowired
private BanqueImp banqueImp;
    @QueryMapping
    public List<BanqueTest> compteslistes(){
        return banqueRepositori.findAll();
    }
    @QueryMapping
    public BanqueTest comptelist(@Argument String id){
        return banqueRepositori.findById(id).
                orElseThrow(()->new RuntimeException(String.format("acount %s not find", id)));
    }
    @MutationMapping
    public BanqueResponseDTO addcompte(@Argument BanqueRequestDTO banqueDTO){
        return banqueImp.addcomptes(banqueDTO);
    }
    @MutationMapping
    public BanqueResponseDTO update(@Argument String id,@Argument BanqueRequestDTO banqueDTO){
        return banqueImp.update(id, banqueDTO);
    }
    @MutationMapping
    public BanqueResponseDTO delete(@Argument String id,@Argument BanqueRequestDTO banqueDTO){
        return banqueImp.update(id, banqueDTO);
    }
}
