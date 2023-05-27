package com.bancrabs.tempparcial2.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@Table(name = "playlist")
public class Playlist{ 

  @Id
  @Column(name = "code")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID code;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_code", nullable = false)
  private User user;

  public Playlist(String title, String description, User user) {
    this.title = title;
    this.description = description;
    this.user = user;
  }
}