package com.ayrtonCarvalho.workshopMongo.repository;

import com.ayrtonCarvalho.workshopMongo.DoMain.Post;
import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
