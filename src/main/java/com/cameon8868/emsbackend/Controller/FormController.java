package com.cameon8868.emsbackend.Controller;

import com.cameon8868.emsbackend.database.User;
import com.cameon8868.emsbackend.database.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class FormController {

    private final UserRepository repository;

    public FormController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public String handleForm(@RequestParam String login, @RequestParam String password) {
        Optional<User> user = repository.findByLogin(login);

        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            return "redirect:/index?error";

        }
        return "redirect:/general";
    }
}