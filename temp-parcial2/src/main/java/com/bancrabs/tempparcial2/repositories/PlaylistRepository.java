package com.bancrabs.tempparcial2.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.bancrabs.tempparcial2.models.entities.Playlist;
import com.bancrabs.tempparcial2.models.entities.User;

import java.util.List;


public interface PlaylistRepository extends ListCrudRepository<Playlist, UUID>{
    List<Playlist> findByTitle(String title);
    List<Playlist> findByTitleContainingIgnoreCaseByOrderByCodeAsc(String title);
    List<Playlist> findByTitleContainingIgnoreCaseByOrderByCodeDesc(String title);
    List<Playlist> findByDescriptionContainingIgnoreCaseByOrderByCodeAsc(String description);
    List<Playlist> findByDescriptionContainingIgnoreCaseByOrderByCodeDesc(String description);
    List<Playlist> findByUserOrderByTitleAsc(User user);
    List<Playlist> findByUserOrderByTitleDesc(User user);
    List<Playlist> findByUserOrderByCodeAsc(User user);
    List<Playlist> findByUserOrderByCodeDesc(User user);
}
