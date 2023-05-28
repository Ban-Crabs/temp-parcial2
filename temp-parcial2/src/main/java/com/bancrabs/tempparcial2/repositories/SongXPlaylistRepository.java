package com.bancrabs.tempparcial2.repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.bancrabs.tempparcial2.models.entities.SongXPlaylist;

public interface SongXPlaylistRepository extends ListCrudRepository<SongXPlaylist, UUID>{
    List<SongXPlaylist> findBySongCode(UUID songCode);
    List<SongXPlaylist> findBySongCodeOrderByDateAddedAsc(UUID songCode);
    List<SongXPlaylist> findBySongCodeOrderByDateAddedDesc(UUID songCode);
    List<SongXPlaylist> findByPlaylistCode(UUID playlistCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByDateAddedAsc(UUID playlistCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByDateAddedDesc(UUID playlistCode);
    List<SongXPlaylist> findBySongCodeOrderByCodeAsc(UUID songCode);
    List<SongXPlaylist> findBySongCodeOrderByCodeDesc(UUID songCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByCodeAsc(UUID playlistCode);
    List<SongXPlaylist> findByPlaylistCodeOrderByCodeDesc(UUID playlistCode);
    List<SongXPlaylist> findByPlaylistCodeAndDateAdded(UUID playlistCode, Timestamp dateAdded);
    SongXPlaylist findBySongCodeAndPlaylistCode(UUID songCode, UUID playlistCode);
    SongXPlaylist findBySongCodeAndPlaylistCodeOrderByDateAddedAsc(UUID songCode, UUID playlistCode);
    SongXPlaylist findBySongCodeAndPlaylistCodeOrderByDateAddedDesc(UUID songCode, UUID playlistCode);
}
