package com.example.demo.web;


import com.example.demo.entity.BanqueTest;
import com.example.demo.repositori.BanqueRepositori;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BanqControlerGraphql {

    private BanqueRepositori banqueRepositori;
    @QueryMapping
    public List<BanqueTest> compteslistes(){
        return banqueRepositori.findAll();
    }
}
