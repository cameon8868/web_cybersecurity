package com.cameon8868.emsbackend.Controller;

import com.cameon8868.emsbackend.database.User;
import com.cameon8868.emsbackend.database.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class FormController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public FormController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public String handleForm(@RequestParam String login, @RequestParam String password, HttpServletRequest request) {
        Optional<User> user = repository.findByLogin(login);

        if (user.isEmpty() || !encoder.matches(password, user.get().getPassword())) {
            return "redirect:/";

        }

        // сбрасываем старую сессию, если она есть, и создаем новую
        HttpSession old = request.getSession(false);
        if (old != null) {
            old.invalidate();
        }
        // создаем новую сессию и сохраняем в ней пользоввателя
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.setAttribute("userLogin", user.get().getLogin());
        }

        return "redirect:/general";
    }
}   