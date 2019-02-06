package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.Role;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.repository.RoleRepository;
import com.dagabienkowska.documentmanager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());


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
        LOGGER.log(Level.INFO, "Created user");
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        LOGGER.log(Level.INFO, "Fetched all users");
        return users;
    }


}
