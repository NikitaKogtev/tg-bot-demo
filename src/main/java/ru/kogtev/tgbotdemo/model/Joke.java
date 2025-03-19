package ru.kogtev.tgbotdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "jokes")
public class Joke {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false)
  private UUID id;

  @Column(name = "joke_text", nullable = false, length = 1000)
  private String jokeText;

  @Enumerated(EnumType.STRING)
  @Column(name = "humor_level", nullable = false)
  private HumorLevel humorLevel;

  @Column(name = "created_user", nullable = false, length = 50)
  private String createdUser;

  @CreationTimestamp
  @Column(name = "created_at")
  private ZonedDateTime createdAt;

  @Column(name = "like_value")
  private Long likeValue;

  @Column(name = "dislike_value")
  private Long dislikeValue;

  public Joke() {

  }

  public Joke(String jokeText, HumorLevel humorLevel, String createdUser) {
    this.jokeText = jokeText;
    this.humorLevel = humorLevel;
    this.createdUser = createdUser;
  }
}
