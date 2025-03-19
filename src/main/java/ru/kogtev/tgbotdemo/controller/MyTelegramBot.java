package ru.kogtev.tgbotdemo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.BotSession;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.AfterBotRegistration;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import ru.kogtev.tgbotdemo.service.JokeService;

import static org.telegram.telegrambots.abilitybots.api.objects.Locality.ALL;
import static org.telegram.telegrambots.abilitybots.api.objects.Privacy.PUBLIC;

@Component
@Log4j2
public class MyTelegramBot extends AbilityBot implements SpringLongPollingBot {
  private final JokeService jokeService;
  private final String botToken;

  public MyTelegramBot(@Value("${telegram.bot.token}") String botToken,
                       @Value("${telegram.bot.name}") String botName,
                       JokeService jokeService) {

    super(new OkHttpTelegramClient(botToken), botName);
    this.botToken = botToken;
    this.jokeService = jokeService;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  @Override
  public long creatorId() {
    return 366518053;
  }

  @Override
  public LongPollingUpdateConsumer getUpdatesConsumer() {
    return this;
  }

  @AfterBotRegistration
  public void afterRegistration(BotSession botSession) {
    this.onRegister();
  }

  public Ability sayJoke() {
    return Ability
        .builder()
        .name("joke")
        .info("get joke")
        .locality(ALL)
        .privacy(PUBLIC)
        .action(context -> silent.send(jokeService.sayJoke(context), context.chatId()))
        .build();
  }

  public Ability sayStart() {
    return Ability
        .builder()
        .name("start")
        .info("says start info")
        .locality(ALL)
        .privacy(PUBLIC)
        .action(ctx -> silent.send("Привет ", ctx.chatId()))
        .build();
  }


  public Ability sayHelloWorld() {
    return Ability
        .builder()
        .name("hello")
        .info("says hello world!")
        .locality(ALL)
        .privacy(PUBLIC)
        .action(ctx -> silent.send("Hello world!", ctx.chatId()))
        .build();
  }


}

