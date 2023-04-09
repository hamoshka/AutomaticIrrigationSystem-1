package com.irrigation.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String redirectToAngularPage() {
        return "redirect:/index.html";
    }
}

