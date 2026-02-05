package com.ayrtonCarvalho.workshopMongo.service;

import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepository ur;

    public List<User> FindAll(){
       return ur.findAll();
    }

}
