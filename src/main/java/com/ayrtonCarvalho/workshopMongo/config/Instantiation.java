package com.ayrtonCarvalho.workshopMongo.config;

import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository ur;

    @Autowired
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("DB = " + mongoTemplate.getDb().getName());
        System.out.println("COLLECTION(User) = " + mongoTemplate.getCollectionName(User.class));

        ur.deleteAll();
        ur.saveAll(Arrays.asList(
                new User(null, "Maria Brown", "maria@gmail.com"),
                new User(null, "Alex Green", "alex@gmail.com"),
                new User(null, "Bob Grey", "bob@gmail.com")
        ));

        System.out.println(">>> TOTAL NO BANCO: " + ur.count());
    }
}
