package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.User;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    String findLoggedInUsername();

    void login(String username, String password);

}
