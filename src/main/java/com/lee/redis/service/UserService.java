package com.lee.redis.service;

import com.lee.redis.domain.User;
import com.lee.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
