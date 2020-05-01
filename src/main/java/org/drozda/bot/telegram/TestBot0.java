package org.drozda.bot.telegram;

import org.drozda.util.EnvVars;
import org.drozda.util.EnvVarsImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBot0 extends TelegramLongPollingBot {

    EnvVars envVars = new EnvVarsImpl();
    private static String NAME = "testbot0";
    private static Logger logger = Logger.getLogger(TestBot0.class.getName());

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        logger.info(update.getMessage().getText());
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    private synchronized void sendMsg(String chatId, String text) {


//        execute()
//        SendDocument
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }


    @Override
    public String getBotToken() {
        return envVars.getEnv(Const.BOT_TOKEN);
    }

    @Override
    public String getBotUsername() {
        return NAME;
    }
}
