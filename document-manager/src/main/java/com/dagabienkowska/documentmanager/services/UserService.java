package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(User user);

    User findByUsername(String username);

    List<User> getAllUsers();

}
