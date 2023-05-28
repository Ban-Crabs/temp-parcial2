package com.bancrabs.tempparcial2.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.bancrabs.tempparcial2.models.entities.SongXPlaylist;

public interface SongXPlaylistRepository extends ListCrudRepository<SongXPlaylist, UUID>{
    List<SongXPlaylist> findBySongCodeOrderByDateAddedAsc(UUID songCode);
    List<SongXPlaylist> findBySongCodeOrderByDateAddedDesc(UUID songCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByDateAddedAsc(UUID playlistCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByDateAddedDesc(UUID playlistCode);
    List<SongXPlaylist> findBySongCodeOrderByCodeAsc(UUID songCode);
    List<SongXPlaylist> findBySongCodeOrderByCodeDesc(UUID songCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByCodeAsc(UUID playlistCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByCodeDesc(UUID playlistCode);
    List<SongXPlaylist> findBySongCodeAndPlaylistCodeOrderByDateAddedAsc(UUID songCode, UUID playlistCode);
    List<SongXPlaylist> findBySongCodeAndPlaylistCodeOrderByDateAddedDesc(UUID songCode, UUID playlistCode);
}
