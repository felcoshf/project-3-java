package com.example.practice_3.service;

import com.example.practice_3.model.User;
import com.example.practice_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User authenticate(String userName, String password) throws Exception {
        User user = userRepository.findByUsername(userName);

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new Exception("Неверный пароль");
        }
    }
}
