package com.cameon8868.emsbackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @PostMapping("/login")

    public String handleForm(@RequestParam String login, @RequestParam String password) {
        System.out.println("Login: " + login + ", Password: " + password);
        
        // redirect нужен для того чтобы после отправки формы не оставаться на странице index.html, а перейти на страницу general.html
        return "redirect:/general"; 
    }
}