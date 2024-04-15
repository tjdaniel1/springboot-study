package com.example.demo.service;

import com.example.demo.domain.Song;
import com.example.demo.dto.request.SongRequest;
import com.example.demo.mapper.SongMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongMapper songMapper;
    public void save(SongRequest req){
        songMapper.insertSong(req.toEntity());
    }

    @Override
    public List<Song> findAllSongs() {
        return songMapper.findAllSong();
    }

    @Override
    public Song updateSong(Long id, SongRequest req) {
        Song songById = findSongById(id);
        if(songById == null) throw new IllegalArgumentException("Song not found");
        Song entity = req.toEntity(id);
        songMapper.updateSong(entity);

        return entity;
    }

    @Override
    public void deleteSong(Long id) {
        songMapper.deleteSong(id);
    }

    @Override
    public Song findSongById(Long id) {
        return songMapper.findSongById(id);
    }
}

