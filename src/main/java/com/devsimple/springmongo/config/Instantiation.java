package com.devsimple.springmongo.config;

import com.devsimple.springmongo.model.User;
import com.devsimple.springmongo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User antonio = new User(null, "Antonio Sousa", "antonio@gmail.com");
        User sheylane = new User(null, "sheylane Sousa", "sheylane@gmail.com");
        User gustavo = new User(null, "Gustavo Henrique", "gustavo@gmail.com");

        userRepository.saveAll(Arrays.asList(antonio, gustavo, sheylane));
    }
}
