package com.ayrtonCarvalho.workshopMongo.resource;

import com.ayrtonCarvalho.workshopMongo.DoMain.Post;
import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.dto.UserDto;
import com.ayrtonCarvalho.workshopMongo.resource.util.URL;
import com.ayrtonCarvalho.workshopMongo.service.PostService;
import com.ayrtonCarvalho.workshopMongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.awt.SystemColor.text;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService us;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = us.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity <List<Post>> findByTitle(@RequestParam (value = "text", defaultValue = "") String text) {

        text = URL.decodeParam(text);
        List<Post> list = us.findByTitle(text);
        return ResponseEntity.ok().body(list);

    }
}