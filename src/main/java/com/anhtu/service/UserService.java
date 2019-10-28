package com.anhtu.service;

import com.anhtu.dao.UserDAO;
import com.anhtu.dao.UserDAOImpl;
import com.anhtu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static UserRepository userRepository;

    @Autowired
    public void setUserDAO(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public static boolean isUsernameAlreadyInUse(String login){
        return userRepository.findByLogin(login) != null;
    }
}
