package com.bancrabs.tempparcial2.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancrabs.tempparcial2.models.dtos.UserRegisterDTO;
import com.bancrabs.tempparcial2.models.entities.User;
import com.bancrabs.tempparcial2.repositories.UserRepository;
import com.bancrabs.tempparcial2.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean register(UserRegisterDTO data) throws Exception {
        try {
            User toRegister = new User(data.getUsername(), data.getEmail(), data.getPassword());
            if (userRepository.findByUsernameOrEmail(data.getUsername()) != null
                    || userRepository.findByUsernameOrEmail(data.getEmail()) != null) {
                return false;
            }
            userRepository.save(toRegister);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean auth(String identifier, String password) throws Exception {
        try {
            User toAuth = userRepository.findByUsernameOrEmail(identifier);
            if (toAuth == null) {
                return false;
            } else {
                if (toAuth.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updatePassword(String identifier, String password) throws Exception {
        try {
            User toUpdate = userRepository.findByUsernameOrEmail(identifier);
            if (toUpdate == null) {
                return false;
            } else {
                toUpdate.setPassword(password);
                userRepository.save(toUpdate);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateEmail(String identifier, String email) throws Exception {
        try {
            User toUpdate = userRepository.findByUsernameOrEmail(identifier);
            if (toUpdate == null) {
                return false;
            } else {
                toUpdate.setEmail(email);
                userRepository.save(toUpdate);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateUsername(String identifier, String username) throws Exception {
        try {
            User toUpdate = userRepository.findByUsernameOrEmail(identifier);
            if (toUpdate == null) {
                return false;
            } else {
                toUpdate.setUsername(username);
                userRepository.save(toUpdate);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(String identifier) throws Exception {
        try {
            User toDelete = userRepository.findByUsernameOrEmail(identifier);
            userRepository.delete(toDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String identifier) {
        User toReturn = userRepository.findByUsernameOrEmail(identifier);
        return toReturn;
    }

}
