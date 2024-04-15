package com.example.demo.dto.request;

import com.example.demo.domain.Song;
import lombok.*;



public record SongRequest(String title, String lyrics) {
    public Song toEntity() {
        return Song.builder()
                .title(title).lyrics(lyrics).build();
    }

    public Song toEntity(Long id) {
        return Song.builder().id(id).title(title).lyrics(lyrics).build();
    }
}