package com.example.apirestnanuvem.domain.service;

import com.example.apirestnanuvem.domain.model.User;



public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
