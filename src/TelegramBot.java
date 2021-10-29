import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TestJavaTalegramBot";
    }

    @Override
    public String getBotToken() {
        return "2060827799:AAFOqIUI-U5yPl3uJdENblW6-CzPBxdSHOg";
    }


    @Override
    public void onUpdateReceived(Update update) {
    }

    public void sendMsg(String id, String text) throws TelegramApiException {
        execute(SendMessage.builder().chatId(id).text(text).build());
    }
}
