package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.Role;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.repository.RoleRepository;
import com.dagabienkowska.documentmanager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> userRole = new HashSet<>();
        userRole.add(roleRepository.findRoleByName("User"));
        user.setRoles(userRole);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }





}
