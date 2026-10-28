package com.cameon8868.emsbackend.Controller;

import com.cameon8868.emsbackend.database.User;
import com.cameon8868.emsbackend.database.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
    public String handleForm(@RequestParam String login, @RequestParam String password, HttpServletRequest request) {
        Optional<User> user = repository.findByLogin(login);

        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            return "redirect:/LogIn";

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