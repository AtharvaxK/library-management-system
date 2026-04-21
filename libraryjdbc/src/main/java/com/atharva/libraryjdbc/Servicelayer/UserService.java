package com.atharva.libraryjdbc.Servicelayer;

import java.util.List;

import com.atharva.libraryjdbc.model.User;

public interface UserService {
    public void addUsers(User user);
    public User getUserById(int id);
    public List<User> getAllUsers();
    
}
