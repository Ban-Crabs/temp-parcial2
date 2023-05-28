package com.bancrabs.tempparcial2.services;

import java.sql.Timestamp;
import java.util.List;

import com.bancrabs.tempparcial2.models.entities.Playlist;
import com.bancrabs.tempparcial2.models.entities.Song;

public interface SongXPlaylistService {
    Boolean addSongToPlaylist(String songId, Integer duration, String playlistId, String userId) throws Exception;
    Boolean removeSongFromPlaylist(String songId, Integer duration, String playlistId, String userId) throws Exception;

    List<Song> findAllSongsInPlaylist(String playlistId, String userId);
    List<Song> findAllSongsNotInPlaylist(String playlistId, String userId);
    List<Playlist> findAllPlaylistsContainingSong(String songId, Integer duration);
    List<Playlist> findAllPlaylistsNotContainingSong(String songId, Integer duration);
    List<Song> findAllSongsInPlaylistByDuration(String playlistId, String userId, Integer duration);
    List<Song> findAllSongsNotInPlaylistByDuration(String playlistId, String userId, Integer duration);
    List<Song> findAllSongsInPlaylistByDate(String playlistId, String userId, Timestamp date);
    List<Song> findAllSongsNotInPlaylistByDate(String playlistId, String userId, Timestamp date);
}
