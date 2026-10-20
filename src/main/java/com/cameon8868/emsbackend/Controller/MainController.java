package com.cameon8868.emsbackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    @GetMapping ("/general")
    public String general() {
        return "general"; 
    }
}