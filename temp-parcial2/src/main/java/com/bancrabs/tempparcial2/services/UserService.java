package com.bancrabs.tempparcial2.services;

import java.util.List;

import com.bancrabs.tempparcial2.models.dtos.UserRegisterDTO;
import com.bancrabs.tempparcial2.models.entities.User;

public interface UserService {
    Boolean register(UserRegisterDTO data) throws Exception;
    Boolean auth(String identifier, String password) throws Exception;
    Boolean updatePassword(String identifier, String password) throws Exception;
    Boolean updateEmail(String identifier, String email) throws Exception;
    Boolean updateUsername(String identifier, String username) throws Exception;
    Boolean delete(String identifier) throws Exception;

    List<User> findAll();
    User findById(String identifier);
}
