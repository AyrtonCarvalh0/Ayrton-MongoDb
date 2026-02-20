package com.ayrtonCarvalho.workshopMongo.service;

import com.ayrtonCarvalho.workshopMongo.DoMain.Post;
import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.dto.UserDto;
import com.ayrtonCarvalho.workshopMongo.repository.PostRepository;
import com.ayrtonCarvalho.workshopMongo.repository.UserRepository;
import com.ayrtonCarvalho.workshopMongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository ur;

    public List<Post> FindAll() {
        return ur.findAll();
    }

    public Post findById(String id) {
        Post post = ur.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return ur.searchTitle(text);
    }
}