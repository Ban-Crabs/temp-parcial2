package com.bancrabs.tempparcial2.services;

import java.util.List;

import com.bancrabs.tempparcial2.models.dtos.SongSaveDTO;
import com.bancrabs.tempparcial2.models.entities.Song;

public interface SongService {
    Boolean save(SongSaveDTO data) throws Exception;
    Boolean deleteByIdAndDuration(String identifier, Integer duration) throws Exception;

    List<Song> findAll();
    List<Song> findByIdAndDuration(String identifier, Integer duration);
}
