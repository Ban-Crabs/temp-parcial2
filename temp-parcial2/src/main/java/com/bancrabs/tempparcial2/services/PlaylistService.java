package com.bancrabs.tempparcial2.services;

import java.util.List;

import com.bancrabs.tempparcial2.models.dtos.PlaylistSaveDTO;
import com.bancrabs.tempparcial2.models.entities.Playlist;

public interface PlaylistService {
    Boolean save(PlaylistSaveDTO data) throws Exception;
    Boolean deleteById(String identifier, String userId) throws Exception;

    List<Playlist> findAll();
    Playlist findById(String identifier, String userId);
}
