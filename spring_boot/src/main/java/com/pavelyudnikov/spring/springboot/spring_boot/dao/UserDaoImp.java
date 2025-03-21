package com.pavelyudnikov.spring.springboot.spring_boot.dao;

import com.pavelyudnikov.spring.springboot.spring_boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() { return entityManager.createQuery("FROM User", User.class).getResultList(); }

    @Override
    public void remove(int id) { entityManager.remove(show(id)); }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
