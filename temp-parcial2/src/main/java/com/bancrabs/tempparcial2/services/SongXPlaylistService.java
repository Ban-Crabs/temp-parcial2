package com.bancrabs.tempparcial2.services;

import java.sql.Timestamp;
import java.util.List;

import com.bancrabs.tempparcial2.models.dtos.PlaylistRepoFindDTO;
import com.bancrabs.tempparcial2.models.dtos.SongRepoFindDTO;
import com.bancrabs.tempparcial2.models.entities.Playlist;
import com.bancrabs.tempparcial2.models.entities.Song;

public interface SongXPlaylistService {
    Boolean addSongToPlaylist(SongRepoFindDTO songData, PlaylistRepoFindDTO playlistData) throws Exception;
    Boolean removeSongFromPlaylist(SongRepoFindDTO songData, PlaylistRepoFindDTO playlistData) throws Exception;

    List<Song> findAllSongsInPlaylist(PlaylistRepoFindDTO playlistData);
    List<Song> findAllSongsNotInPlaylist(PlaylistRepoFindDTO playlistData);
    List<Playlist> findAllPlaylistsContainingSong(SongRepoFindDTO songData);
    List<Playlist> findAllPlaylistsNotContainingSong(SongRepoFindDTO songData);
    List<Song> findAllSongsInPlaylistByDuration(PlaylistRepoFindDTO playlistData, Integer duration);
    List<Song> findAllSongsNotInPlaylistByDuration(PlaylistRepoFindDTO playlistData, Integer duration);
    List<Song> findAllSongsInPlaylistByDate(PlaylistRepoFindDTO playlistData, Timestamp date);
    List<Song> findAllSongsNotInPlaylistByDate(PlaylistRepoFindDTO playlistData, Timestamp date);
}
