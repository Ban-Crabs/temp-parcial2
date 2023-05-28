package com.bancrabs.tempparcial2.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.bancrabs.tempparcial2.models.entities.User;

public interface UserRepository extends ListCrudRepository<User, UUID> {
    User findByUsernameOrEmail(String identifier);
    List<User> findByUsernameOrEmailContainingIgnoreCaseByOrderByCodeAsc(String identifier);
    List<User> findByUsernameOrEmailContainingIgnoreCaseByOrderByCodeDesc(String identifier);
}