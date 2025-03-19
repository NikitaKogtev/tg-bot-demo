package ru.kogtev.tgbotdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;
import ru.kogtev.tgbotdemo.jpa.JokeRepository;
import ru.kogtev.tgbotdemo.model.Joke;

import java.util.List;
import java.util.Random;

@Service
@Log4j2
@RequiredArgsConstructor
public class JokeService {
  private final JokeRepository jokeRepository;
  private final Random random = new Random();

  public String sayJoke(MessageContext context) {
    List<Joke> jokeList = jokeRepository.findAll();
    Joke joke = jokeList.get(this.random.nextInt(jokeList.size()));
    log.info("User - {} get joke - {}", context.user().toString(), joke.getJokeText());
    return joke.getJokeText();
  }
}
