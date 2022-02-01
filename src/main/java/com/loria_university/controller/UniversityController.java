package com.loria_university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loria")
public class UniversityController {

    @GetMapping("")
    public String showWelcomePage() {
        return "welcome-page";
    }

}
