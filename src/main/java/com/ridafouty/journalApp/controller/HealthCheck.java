package com.ridafouty.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/health-check") // maps the below function to this endpoint
    public String checkHealth(){
        return "OK";
    }
}
