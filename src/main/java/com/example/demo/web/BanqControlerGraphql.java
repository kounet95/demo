package com.example.demo.web;


import com.example.demo.entity.BanqueTest;
import com.example.demo.repositori.BanqueRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BanqControlerGraphql {
@Autowired
    private BanqueRepositori banqueRepositori;
    @QueryMapping
    public List<BanqueTest> compteslistes(){
        return banqueRepositori.findAll();
    }
    @QueryMapping
    public BanqueTest comptelist(@Argument String id){
        return banqueRepositori.findById(id).
                orElseThrow(()->new RuntimeException(String.format("acount %s not find", id)));
    }
}
