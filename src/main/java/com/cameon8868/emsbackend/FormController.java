package com.cameon8868.emsbackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @PostMapping("/general.html")
    @ResponseBody
    public String handleForm(@RequestParam String login, @RequestParam String password) {
        System.out.println("Login: " + login + ", Password: " + password);
        
        // Пока просто возвращаем текст в браузер (потом заменим на HTML-страницу)
        return "Hi, " + login + "!"; 
    }
}