package com.atharva.libraryjdbc.Servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atharva.libraryjdbc.model.User;
import com.atharva.libraryjdbc.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void addUsers(User user){
        userRepository.addUsers(user);
    }

    @Override
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    
}
