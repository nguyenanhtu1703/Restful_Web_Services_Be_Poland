package com.anhtu.dao;

import com.anhtu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        System.out.println("125");
        this.entityManager = entityManager;
    }


    @Override
    public User getActiveUser(String login) {
        Object user;

        try {
            user = entityManager.createQuery("from User u where u.login = :login").getFirstResult();
        } catch (NoResultException e) {
            user = null;
        }
        if (user != null)
            return new User("1", "2", "3", "4");

        return null;
    }
}
