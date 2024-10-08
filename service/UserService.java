package com.javacrud.service;

import com.javacrud.model.User;
import com.javacrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id);

        if(user == null){
            throw new RuntimeException("User not found for id :: " + id);
        } else {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setActive(userDetails.isActive());
            return userRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
