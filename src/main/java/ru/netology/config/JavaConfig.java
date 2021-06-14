package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.controller.PostController;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;

@Configuration
public class JavaConfig {
    @Bean
    PostController postController(PostService service){
        return new PostController(service);
    }

    @Bean
    PostService postService(PostRepository postRepository){
        return new PostService(postRepository);
    }

    @Bean
    PostRepository postRepository(){
        return new PostRepository();
    }
}
