package com.ayrtonCarvalho.workshopMongo.service;

import com.ayrtonCarvalho.workshopMongo.DoMain.User;
import com.ayrtonCarvalho.workshopMongo.dto.UserDto;
import com.ayrtonCarvalho.workshopMongo.repository.UserRepository;
import com.ayrtonCarvalho.workshopMongo.service.exception.ObjectNotFoundException;
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

    public User findById(String id){
        User user = ur.findById(id).orElse(null);
        if(user == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }
    public User insert (User obj ) {
        return ur.insert(obj);
    }


    public void delete(String id){
        findById(id);
        ur.deleteById(id);
    }

    public User update(User obj){
        User newObj = ur.findById(obj.getId()).orElse(null);
        updateData(newObj,obj);
        return ur.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO(UserDto objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

}
