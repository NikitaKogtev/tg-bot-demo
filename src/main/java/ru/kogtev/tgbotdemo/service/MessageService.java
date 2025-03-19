package ru.kogtev.tgbotdemo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Log4j2
public class MessageService {

  public SendMessage messageReceiver(Update update) {

    if (update.hasMessage() && update.getMessage().hasText()) {
      String text = update.getMessage().getText();
      long chatId = update.getMessage().getChatId();

      String responseText;
      if (text.equals("/start")) {
        responseText = "Алексей лох";
      } else responseText = text;

      SendMessage message = SendMessage
          .builder()
          .chatId(chatId)
          .text(responseText)
          .build();

      log.info(message);
      return message;
    }
    return null;
  }

}
