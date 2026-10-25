package com.cameon8868.emsbackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/general")
    public String general(HttpSession session, Model model) {
        String username = (String) session.getAttribute("userLogin");
        model.addAttribute("username", username);
        return "general";
    }
}