package com.brazhenko.service;

import com.brazhenko.dao.UserDAOImpl;
import com.brazhenko.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 05.08.2015.
 */
@Service
public class UserService {

    @Autowired
    private UserDAOImpl userDAO;

    public Long addUser (User user){
        Long id = userDAO.addUser(user);
        return id;
    }

    public List<User> getUser(){
        List userId= userDAO.getUser();
        return userId;
    }

    public User getUserById(Long id){
        User userr = userDAO.getUserById(id);
        return userr;
    }

    public User getUserByEmail(String email){
        User user=userDAO.getUserByEmail(email);
        return user;
    }

    public void updateUser(User users){
        userDAO.updateUser(users);
    }

    public void deleteUser(User users){
        userDAO.deleteUser(users);
    }
}
