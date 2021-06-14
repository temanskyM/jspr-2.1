package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PostRepository {
    private final ConcurrentHashMap<Long, Post> map = new ConcurrentHashMap<>();
    private long id;

    public List<Post> all() {
        return new ArrayList<>(map.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(map.get(id));
    }

    public synchronized Post save(Post post) {
        if (post.getId() == 0) {
            id++;
            post.setId(id);
        }
        map.put(id, post);
        return post;
    }

    public void removeById(long id) {
        map.remove(id);
    }
}
