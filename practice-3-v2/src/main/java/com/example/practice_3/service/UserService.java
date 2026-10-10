package com.example.practice_3.service;

import com.example.practice_3.model.User;
import com.example.practice_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) throws Exception {
        User existing = userRepository.findByUsername(user.getUsername());
        if (existing != null) {
            throw new Exception("Пользователь с таким логином уже существует");
        }
        return userRepository.save(user);
    }

    public User authenticate(String userName, String password) throws Exception {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new Exception("Пользователь не найден");
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("Неверный пароль");
        }
        return user;
    }
}
