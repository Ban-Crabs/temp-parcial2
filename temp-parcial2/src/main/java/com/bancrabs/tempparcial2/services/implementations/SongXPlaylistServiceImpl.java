package com.bancrabs.tempparcial2.services.implementations;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancrabs.tempparcial2.models.dtos.PlaylistRepoFindDTO;
import com.bancrabs.tempparcial2.models.dtos.SongRepoFindDTO;
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
    public Boolean addSongToPlaylist(SongRepoFindDTO songData, PlaylistRepoFindDTO playlistData)
            throws Exception {
        try {
            Song song = songService.findByIdAndDuration(songData);
            Playlist playlist = playlistService.findById(playlistData);
            if (song == null || playlist == null) {
                return false;
            }
            SongXPlaylist toSave = new SongXPlaylist(song, playlist);
            songXPlaylistRepository.save(toSave);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean removeSongFromPlaylist(SongRepoFindDTO songData, PlaylistRepoFindDTO playlistData)
            throws Exception {
        try {
            Song song = songService.findByIdAndDuration(songData);
            Playlist playlist = playlistService.findById(playlistData);
            if (song == null || playlist == null) {
                return false;
            }
            SongXPlaylist toDelete = songXPlaylistRepository.findBySongCodeAndPlaylistCode(song.getCode(),
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
    public List<Song> findAllSongsInPlaylist(PlaylistRepoFindDTO playlistData) {
        try {
            Playlist playlist = playlistService.findById(playlistData);
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
    public List<Song> findAllSongsNotInPlaylist(PlaylistRepoFindDTO playlistData) {
        try{
            Playlist playlist = playlistService.findById(playlistData);
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
    public List<Playlist> findAllPlaylistsContainingSong(SongRepoFindDTO songData) {
        try{
            Song song = songService.findByIdAndDuration(songData);
            if(song == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findBySongCode(song.getCode());
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
    public List<Playlist> findAllPlaylistsNotContainingSong(SongRepoFindDTO songData) {
        try{
            Song song = songService.findByIdAndDuration(songData);
            if(song == null){
                return null;
            }
            List<SongXPlaylist> songsXPlaylist = songXPlaylistRepository.findBySongCode(song.getCode());
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
    public List<Song> findAllSongsInPlaylistByDuration(PlaylistRepoFindDTO playlistData, Integer duration) {
        try{
            Playlist playlist = playlistService.findById(playlistData);
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
    public List<Song> findAllSongsNotInPlaylistByDuration(PlaylistRepoFindDTO playlistData, Integer duration) {
        try{
            Playlist playlist = playlistService.findById(playlistData);
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
    public List<Song> findAllSongsInPlaylistByDate(PlaylistRepoFindDTO playlistData, Timestamp date) {
        try{
            Playlist playlist = playlistService.findById(playlistData);
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
    public List<Song> findAllSongsNotInPlaylistByDate(PlaylistRepoFindDTO playlistData, Timestamp date) {
        try{
            Playlist playlist = playlistService.findById(playlistData);
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
