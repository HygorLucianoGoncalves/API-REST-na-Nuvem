package com.example.apirestnanuvem.domain.impl;

import com.example.apirestnanuvem.domain.model.User;
import com.example.apirestnanuvem.domain.repository.UserRepository;
import com.example.apirestnanuvem.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("o id ja existes ");
        }
        return userRepository.save(userToCreate);
    }
}
