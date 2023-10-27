import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class NasaBot extends TelegramLongPollingBot {
    final String BOT_NAME;
    final String BOT_TOKEN;
    final String URL = "https://api.nasa.gov/planetary/apod" +
            "?api_key=rhzlpvj0Ba6u0hAImIogzKqvVE05upMT4sA2f3N0";

    final String ID = "iOCrYZQ2VV6qat-P0MCPSdUucC1lZFWjmWpPasakYcM";
    String path1 = "https://api.unsplash.com/search/photos?query=";
    String path2 = "&per_page=1&orientation=landscape&client_id=" + ID;
    public NasaBot(String BOT_NAME, String BOT_TOKEN) {
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // TODO
        if (update.hasMessage() && update.getMessage().hasText()) {
//            /help
//            /image
//            /date 2023-10-24
            String[] separatedAnswer = update.getMessage().getText().split(" ");

            String action = separatedAnswer[0];
            long chatId = update.getMessage().getChatId();

            switch (action) {
                case "/help":
                    sendMessage("I'm NASA bot and can provide pic of the day.  Try /today or /date YYYY-MM-DD", chatId);
                    break;
                case "/today":
                    String url = Utils.getUrl(URL);
                    sendMessage(url, chatId);
                    break;
                case "/test":
                    url = Utils.getUrl(path1 + separatedAnswer[1] + path2);
                    sendMessage(url, chatId);
                    break;
                case "/start":
                          sendMessage("Hello, I'm NASA bot and can show the Astronomy Picture of the Day", chatId);
                    break;
                case "/date":
                    url = Utils.getUrl(URL + "&date=" + separatedAnswer[1]);
                    sendMessage(url, chatId);
                    break;
                default:
                    sendMessage("Sorry. Please try /help to get details", chatId);
            }
        }
    }

    void sendMessage(String msg, long chatId) {
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chatId);
        message.setText(msg);

        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            System.out.println("Can't send message");
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        // TODO
        return BOT_TOKEN;
    }
}
