package com.hr_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class HomeController {

    @GetMapping("/")
    public String redirectToReact() {
        return "redirect:http://localhost:3000";
    }
}