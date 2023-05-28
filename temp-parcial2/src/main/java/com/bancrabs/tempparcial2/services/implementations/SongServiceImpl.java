package com.bancrabs.tempparcial2.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancrabs.tempparcial2.models.dtos.SongRepoFindDTO;
import com.bancrabs.tempparcial2.models.dtos.SongSaveDTO;
import com.bancrabs.tempparcial2.models.entities.Song;
import com.bancrabs.tempparcial2.repositories.SongRepository;
import com.bancrabs.tempparcial2.services.SongService;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Override
    public Boolean save(SongSaveDTO data) throws Exception {
        try{
            Song toSave = new Song(data.getTitle(), data.getDuration());
            songRepository.save(toSave);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteByIdAndDuration(SongRepoFindDTO songData) throws Exception {
        try{
            Song toDelete = songRepository.findByTitleAndDuration(songData.getSongId(), songData.getDuration());
            if(toDelete == null){
                return false;
            }
            else{
                songRepository.delete(toDelete);
                return true;
            }
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findByIdAndDuration(SongRepoFindDTO songData) {
        return songRepository.findByTitleAndDuration(songData.getSongId(), songData.getDuration());
    }
    
}
