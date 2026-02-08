package com.ayrtonCarvalho.workshopMongo.resource;

import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.dto.UserDto;
import com.ayrtonCarvalho.workshopMongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService us;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity < List <UserDto>> findAll(){
        List<User>  list =us.FindAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
        }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity <UserDto> findById(@PathVariable String id){
        User obj = us.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));
    }



    }
