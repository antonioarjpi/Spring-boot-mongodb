package com.devsimple.springmongo.controller;

import com.devsimple.springmongo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User antonio = new User(1L, "Antônio", "antonio@gmail.com");
        User mario = new User(2L, "Mario", "mario@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(antonio, mario));
        return ResponseEntity.ok().body(list);

    }
}
