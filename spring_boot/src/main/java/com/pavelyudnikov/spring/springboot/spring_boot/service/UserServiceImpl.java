package com.pavelyudnikov.spring.springboot.spring_boot.service;

import com.pavelyudnikov.spring.springboot.spring_boot.dao.UserDao;
import com.pavelyudnikov.spring.springboot.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDao.show(id);
    }
}
