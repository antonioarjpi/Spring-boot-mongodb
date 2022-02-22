package com.devsimple.springmongo.config;

import com.devsimple.springmongo.Dto.AuthorDTO;
import com.devsimple.springmongo.model.Post;
import com.devsimple.springmongo.model.User;
import com.devsimple.springmongo.repository.PostRepository;
import com.devsimple.springmongo.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User antonio = new User(null, "Antonio Sousa", "antonio@gmail.com");
        User sheylane = new User(null, "sheylane Sousa", "sheylane@gmail.com");
        User gustavo = new User(null, "Gustavo Henrique", "gustavo@gmail.com");

        userRepository.saveAll(Arrays.asList(antonio, gustavo, sheylane));

        Post post1 = new Post(null, "Indo passear", sdf.parse("22/02/2022"), "Tô indo ali para Fortaleza", new AuthorDTO(antonio));
        Post post2 = new Post(null, "Cheguei em Fortaleza", sdf.parse("23/02/2022"), "Graças a Deus cheguei com segurança!", new AuthorDTO(antonio));

        postRepository.saveAll(Arrays.asList(post1, post2));

        antonio.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(antonio);

    }
}
