package com.bancrabs.tempparcial2.models.entities;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "songxplaylist")
public class SongXPlaylist {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "song_code", nullable = false)
    private Song song;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "playlist_code", nullable = false)
    private Playlist playlist;

    @Column(name = "date_added")
    private Timestamp dateAdded;

    public SongXPlaylist(Song song, Playlist playlist) {
        this.song = song;
        this.playlist = playlist;
        this.dateAdded = new Timestamp(System.currentTimeMillis());
    }

    public SongXPlaylist(Song song, Playlist playlist, Timestamp dateAdded) {
        this.song = song;
        this.playlist = playlist;
        this.dateAdded = dateAdded;
    }
}
