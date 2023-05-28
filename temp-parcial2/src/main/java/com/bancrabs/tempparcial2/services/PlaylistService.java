package com.bancrabs.tempparcial2.services;

import java.util.List;

import com.bancrabs.tempparcial2.models.dtos.PlaylistRepoFindDTO;
import com.bancrabs.tempparcial2.models.dtos.PlaylistSaveDTO;
import com.bancrabs.tempparcial2.models.entities.Playlist;

public interface PlaylistService {
    Boolean save(PlaylistSaveDTO data) throws Exception;
    Boolean deleteById(PlaylistRepoFindDTO playlistData) throws Exception;

    List<Playlist> findAll();
    Playlist findById(PlaylistRepoFindDTO playlistData);
}
