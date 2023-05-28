package com.bancrabs.tempparcial2.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancrabs.tempparcial2.models.dtos.PlaylistSaveDTO;
import com.bancrabs.tempparcial2.models.entities.Playlist;
import com.bancrabs.tempparcial2.models.entities.User;
import com.bancrabs.tempparcial2.repositories.PlaylistRepository;
import com.bancrabs.tempparcial2.services.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Boolean save(PlaylistSaveDTO data) throws Exception {
        try{
            User owner = userService.findById(data.getUserId());
            if(owner == null){
                return false;
            }
            Playlist toSave = new Playlist(data.getTitle(), data.getDescription(), owner);
            playlistRepository.save(toSave);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteById(String identifier, String userId) throws Exception {
        try{
            User owner = userService.findById(userId);
            if(owner == null){
                return false;
            }
            Playlist toDelete = playlistRepository.findByTitleAndUser(identifier, owner);
            if(toDelete == null){
                return false;
            }
            else{
                playlistRepository.delete(toDelete);
                return true;
            }
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist findById(String identifier, String userId) {
        User owner = userService.findById(userId);
        if(owner == null){
            return null;
        }
        Playlist toFind = playlistRepository.findByTitleAndUser(identifier, owner);
        return toFind;
    }
    
}
