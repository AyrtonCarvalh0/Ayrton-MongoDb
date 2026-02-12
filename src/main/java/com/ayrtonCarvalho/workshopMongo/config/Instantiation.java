package com.ayrtonCarvalho.workshopMongo.config;

import com.ayrtonCarvalho.workshopMongo.DoMain.Post;
import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.dto.AuthorDTO;
import com.ayrtonCarvalho.workshopMongo.repository.PostRepository;
import com.ayrtonCarvalho.workshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository ur;

    @Autowired
    private PostRepository pr;

    @Autowired
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        ur.deleteAll();
        pr.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex =   new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        ur.saveAll(Arrays.asList(maria, alex, bob));


        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "I'm happy today", new AuthorDTO(maria));
        pr.saveAll(Arrays.asList(post1, post2));


        System.out.println(">>> TOTAL NO BANCO: " + ur.count());
    }
}
