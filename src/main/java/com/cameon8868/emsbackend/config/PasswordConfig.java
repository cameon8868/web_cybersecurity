package com.cameon8868.emsbackend.config;

import org.springframework.context.annotation.Bean; // Bean для указания, что метод возвращает объект, который должен быть зарегистрирован как Spring Bean 
import org.springframework.context.annotation.Configuration; // Configuration для указания, что этот класс является конфигурационным
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // BCryptPasswordEncoder для хеширования паролей
import org.springframework.security.crypto.password.PasswordEncoder; // PasswordEncoder для интерфейса хеширования паролей

@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}