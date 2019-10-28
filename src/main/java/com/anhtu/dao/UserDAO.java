package com.anhtu.dao;

import com.anhtu.entity.User;

public interface UserDAO {
    User getActiveUser(String username);
}
