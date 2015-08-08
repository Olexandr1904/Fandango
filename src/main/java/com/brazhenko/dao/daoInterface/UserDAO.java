package com.brazhenko.dao.daoInterface;

import com.brazhenko.entity.User;

import java.util.List;

/**
 * Created by Admin on 05.08.2015.
 */
public interface UserDAO {

    //Method to write new User in the DB
    Long addUser(User user);

    //Method to read all User
    List<User> getUser();

    User getUserById(Long id);

    //Method to update User
    void updateUser(User user);

    //Method to delete User
    void deleteUser (User user);

    //Get User by Email
    User getUserByEmail (String email);
}
