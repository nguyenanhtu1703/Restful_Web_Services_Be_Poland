package com.anhtu.repository;

import com.anhtu.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Override
    List<User> findAll();
    User findByLogin(String login);
}

