package com.pavelyudnikov.spring.springboot.spring_boot.dao;

import com.pavelyudnikov.spring.springboot.spring_boot.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void save(User user);

    void update(User user);

    void remove(int id);

    User show(int id);
}

