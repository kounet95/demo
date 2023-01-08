package com.example.demo.web;

import com.example.demo.entity.BanqueTest;
import com.example.demo.repositori.BanqueRepositori;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BanqControllerRest {

    private BanqueRepositori banqueRepositori;


    public BanqControllerRest(BanqueRepositori banqueRepositori) {
        this.banqueRepositori = banqueRepositori;
    }
    @GetMapping("kounet")
    public void kounett(){

    }
    @GetMapping("/banqueTests")
    public List<BanqueTest> banqueTests(){
        return banqueRepositori.findAll();
    }

    @GetMapping("/banqueTests/{id}")
     public BanqueTest bankAccount (@PathVariable String id) {
        return banqueRepositori.findById(id).
                orElseThrow(()->new RuntimeException(String.format("Account %s notfound",id)));
                //.orElseThrow(()-›new RuntimeException(String.format("Account %s notfound",id)));
    }
}
