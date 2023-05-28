package com.bancrabs.tempparcial2.services.implementations;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancrabs.tempparcial2.models.entities.Playlist;
import com.bancrabs.tempparcial2.models.entities.Song;
import com.bancrabs.tempparcial2.models.entities.SongXPlaylist;
import com.bancrabs.tempparcial2.repositories.SongXPlaylistRepository;
import com.bancrabs.tempparcial2.services.SongXPlaylistService;

@Service
public class SongXPlaylistServiceImpl implements SongXPlaylistService {

    @Autowired
    private SongServiceImpl songService;

    @Autowired
    private PlaylistServiceImpl playlistService;

    @Autowired
    private SongXPlaylistRepository songXPlaylistRepository;

    @Override
    public Boolean addSongToPlaylist(String songId, Integer duration, String playlistId, String userId)
            throws Exception {
        try {
            List<Song> song = songService.findByIdAndDuration(userId, duration);
            Playlist playlist = playlistService.findById(playlistId, userId);
            if (song == null || playlist == null) {
                return false;
            }
            SongXPlaylist toSave = new SongXPlaylist(song.get(0), playlist);
            songXPlaylistRepository.save(toSave);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean removeSongFromPlaylist(String songId, Integer duration, String playlistId, String userId)
            throws Exception {
        try {
            List<Song> song = songService.findByIdAndDuration(userId, duration);
            Playlist playlist = playlistService.findById(playlistId, userId);
            if (song == null || playlist == null) {
                return false;
            }
            SongXPlaylist toDelete = songXPlaylistRepository.findBySongCodeAndPlaylistCode(song.get(0).getCode(),
                    playlist.getCode());
            if (toDelete == null) {
                return false;
            } else {
                songXPlaylistRepository.delete(toDelete);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Song> findAllSongsInPlaylist(String playlistId, String userId) {
        try {
            Playlist playlist = playlistService.findById(playlistId, userId);
            if (playlist == null) {
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findByPlaylistCode(playlist.getCode());
            if (songsXPlaylist == null) {
                return null;
            }
            List<Song> songs = List.of();
            songsXPlaylist.forEach(sp -> {
                songs.add(sp.getSong());
            });
            return songs;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Song> findAllSongsNotInPlaylist(String playlistId, String userId) {
        try{
            Playlist playlist = playlistService.findById(playlistId, userId);
            if(playlist == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findByPlaylistCode(playlist.getCode());
            if(songsXPlaylist == null){
                return null;
            }
            List<Song> songs = List.of();
            songsXPlaylist.forEach(sp -> {
                songs.add(sp.getSong());
            });
            List<Song> allSongs = songService.findAll();
            allSongs.removeAll(songs);
            return allSongs;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Playlist> findAllPlaylistsContainingSong(String songId, Integer duration) {
        try{
            List<Song> song = songService.findByIdAndDuration(songId, duration);
            if(song == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findBySongCode(song.get(0).getCode());
            if(songsXPlaylist == null){
                return null;
            }
            List<Playlist> playlists = List.of();
            songsXPlaylist.forEach(sp -> {
                playlists.add(sp.getPlaylist());
            });
            return playlists;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Playlist> findAllPlaylistsNotContainingSong(String songId, Integer duration) {
        try{
            List<Song> song = songService.findByIdAndDuration(songId, duration);
            if(song == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findBySongCode(song.get(0).getCode());
            if(songsXPlaylist == null){
                return null;
            }
            List<Playlist> playlists = List.of();
            songsXPlaylist.forEach(sp -> {
                playlists.add(sp.getPlaylist());
            });
            List<Playlist> allPlaylists = playlistService.findAll();
            allPlaylists.removeAll(playlists);
            return allPlaylists;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Song> findAllSongsInPlaylistByDuration(String playlistId, String userId, Integer duration) {
        try{
            Playlist playlist = playlistService.findById(playlistId, userId);
            if(playlist == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findByPlaylistCode(playlist.getCode());
            if(songsXPlaylist == null){
                return null;
            }
            List<Song> songs = List.of();
            songsXPlaylist.forEach(sp -> {
                if(sp.getSong().getDuration() == duration){
                    songs.add(sp.getSong());
                }
            });
            return songs;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Song> findAllSongsNotInPlaylistByDuration(String playlistId, String userId, Integer duration) {
        try{
            Playlist playlist = playlistService.findById(playlistId, userId);
            if(playlist == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findByPlaylistCode(playlist.getCode());
            if(songsXPlaylist == null){
                return null;
            }
            List<Song> songs = List.of();
            songsXPlaylist.forEach(sp -> {
                if(sp.getSong().getDuration() == duration){
                    songs.add(sp.getSong());
                }
            });
            List<Song> allSongs = songService.findAll();
            allSongs.removeAll(songs);
            return allSongs;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Song> findAllSongsInPlaylistByDate(String playlistId, String userId, Timestamp date) {
        try{
            Playlist playlist = playlistService.findById(playlistId, userId);
            if(playlist == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findByPlaylistCode(playlist.getCode());
            if(songsXPlaylist == null){
                return null;
            }
            List<Song> songs = List.of();
            songsXPlaylist.forEach(sp -> {
                if(sp.getDateAdded().equals(date)){
                    songs.add(sp.getSong());
                }
            });
            return songs;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Song> findAllSongsNotInPlaylistByDate(String playlistId, String userId, Timestamp date) {
        try{
            Playlist playlist = playlistService.findById(playlistId, userId);
            if(playlist == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findByPlaylistCode(playlist.getCode());
            List<SongXPlaylist> allSongXPlaylists = songXPlaylistRepository.findAll();
            if(songsXPlaylist == null || allSongXPlaylists == null){
                return null;
            }
            allSongXPlaylists.removeAll(songsXPlaylist);
            List<Song> songs = List.of();
            allSongXPlaylists.forEach(sp -> {
                if(sp.getDateAdded().equals(date)){
                    songs.add(sp.getSong());
                }
            });
            List<Song> allSongs = songService.findAll();
            allSongs.removeAll(songs);
            return allSongs;
        } catch(Exception e){
            return null;
        }
    }
}
