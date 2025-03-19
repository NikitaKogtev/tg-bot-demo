package ru.kogtev.tgbotdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.kogtev.tgbotdemo.model.Joke;

import java.util.UUID;

@Repository
public interface JokeRepository extends JpaRepository<Joke, UUID>, JpaSpecificationExecutor<Joke> {
}
