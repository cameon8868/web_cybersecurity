package com.cameon8868.emsbackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/general")
    public String general(@RequestParam(required = false) String username, Model model) {
        model.addAttribute("username", username);
        return "general";
    }
}