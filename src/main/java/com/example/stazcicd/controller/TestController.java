package com.example.stazcicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public String healthCheck() {
        return "on going!";
    }

    @GetMapping("/stress")
    public Integer stressTest() {
        Integer result = 0;
        for(int i=1; i<=100; i++) {
            result += i;
        }
        return result;
    }

    @GetMapping("/conf")
    public String checkDiffConf() {
        return "different nginx conf is working";
    }
}
