package com.bancrabs.tempparcial2.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.bancrabs.tempparcial2.models.entities.Song;
import java.util.List;


public interface SongRepository extends ListCrudRepository<Song, UUID>{
    List<Song> findByTitle(String title);
    List<Song> findByTitleContainingIgnoreCaseByOrderByCodeAsc(String title);
    List<Song> findByTitleContainingIgnoreCaseByOrderByCodeDesc(String title);
    List<Song> findByDurationOrderByCodeAsc(Integer duration);
    List<Song> findByDurationOrderByCodeDesc(Integer duration);
    List<Song> findByDurationGreaterThanEqualOrderByCodeAsc(Integer duration);
    List<Song> findByDurationGreaterThanEqualOrderByCodeDesc(Integer duration);
    List<Song> findByDurationLessThanEqualOrderByCodeAsc(Integer duration);
    List<Song> findByDurationLessThanEqualOrderByCodeDesc(Integer duration);
    List<Song> findByDurationGreaterThanOrderByCodeAsc(Integer duration);
    List<Song> findByDurationGreaterThanOrderByCodeDesc(Integer duration);
    List<Song> findByDurationLessThanOrderByCodeAsc(Integer duration);
    List<Song> findByDurationLessThanOrderByCodeDesc(Integer duration);
    List<Song> findByTitleAndDuration(String title, Integer duration);
}
