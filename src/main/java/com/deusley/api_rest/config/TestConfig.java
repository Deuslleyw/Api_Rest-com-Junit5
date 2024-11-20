package com.deusley.api_rest.config;

import com.deusley.api_rest.domain.User;
import com.deusley.api_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository rep;

    @Bean
    public void startDB(){

        User usuario1 = new User(null, "Dev-Deusley", "teste@teste.com", "123");
        User usuario2 = new User(null, "Andreia", "andreia@teste.com", "1236");
        User usuario3 = new User(null, "Davi", "Davi@teste.com", "1234");
        User usuario4 = new User(null, "Helô", "helo@teste.com", "12345");

        rep.saveAll(List.of(usuario1, usuario2, usuario3, usuario4));
    }

}
