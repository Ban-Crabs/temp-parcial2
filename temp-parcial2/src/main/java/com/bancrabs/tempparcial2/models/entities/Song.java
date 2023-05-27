package com.bancrabs.tempparcial2.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "song")
public class Song {
    
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;
    
    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private Integer duration;

    public Song(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }
}
