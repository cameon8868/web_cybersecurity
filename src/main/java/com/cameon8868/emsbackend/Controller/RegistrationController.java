package com.cameon8868.emsbackend.Controller;

import org.springframework.stereotype.Controller; //Controller для обработки HTTP-запросов
import org.springframework.web.bind.annotation.GetMapping; //GetMapping для обработки GET-запросов
import org.springframework.web.bind.annotation.PostMapping; //PostMapping для обработки POST-запросов
import org.springframework.web.bind.annotation.RequestParam; //RequestParam для получения параметров из запроса
import org.springframework.security.crypto.password.PasswordEncoder; //PasswordEncoder для хеширования паролей


import com.cameon8868.emsbackend.database.User; 
import com.cameon8868.emsbackend.database.UserRepository;


import org.springframework.ui.Model; // Model для передачи данных в представление (view)

@Controller 
public class RegistrationController {
    
    private final UserRepository repository; 
    private final PasswordEncoder encoder;

    public RegistrationController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder; 
    }   

    @GetMapping("/register")
    public String RegistrationPages() {
        return "Registration";
    }

    @PostMapping("/register")
    public String handleRegistration(@RequestParam String login, @RequestParam String password, Model model) {
        login = login.trim(); //trim() удаляет пробелы в начале и конце строки
        
        if (login.length() < 3 || password.length() < 8) {
            model.addAttribute("error", "Логин от 3 символов, пароль от 8");
            return "Registration";
        }

        if (repository.findByLogin(login).isPresent()) {
            model.addAttribute("error", "Пользователь с таким логином уже существует");
            return "Registration";
        }

        repository.save(new User(login, encoder.encode(password))); // Нужно захешировать
        return "redirect:/?success";
        
    }
    
        
}
