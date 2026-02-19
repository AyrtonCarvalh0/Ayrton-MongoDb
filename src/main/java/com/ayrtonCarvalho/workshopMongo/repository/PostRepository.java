package com.ayrtonCarvalho.workshopMongo.repository;

import com.ayrtonCarvalho.workshopMongo.DoMain.Post;
import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
