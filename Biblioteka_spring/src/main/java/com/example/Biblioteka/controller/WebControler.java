package com.example.Biblioteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControler{

    @GetMapping("/panel_administracyjny")
    public String panel() {
        return "panel_administracyjny"; // Nazwa pliku HTML (panel_adnimistracyjny.html)
    }

    @GetMapping("/konto")
    public String konto() {
        return "konto"; // Nazwa pliku HTML (konto.html)
    }
}
