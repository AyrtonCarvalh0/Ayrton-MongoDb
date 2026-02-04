package com.ayrtonCarvalho.workshopMongo.resource;

import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity < List <User>> findAll(){
        User maria = new User("Maria Silva" ," maria@gmail.com" ,"1");
        User alex = new User( "Alex Pinto" ," alex@gmail.com","2");
        List<User>  list =new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex));
        return ResponseEntity.ok().body(list);
        }
    }
