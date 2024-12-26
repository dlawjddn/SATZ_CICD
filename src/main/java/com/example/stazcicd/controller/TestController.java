package com.example.stazcicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String healthCheck() {
        return "on going!";
    }

    @GetMapping("/conf")
    public String checkDiffConf() {
        return "different nginx conf is working";
    }
}
