import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramPost extends AnAction {
    private TelegramBot bot = new TelegramBot();
    private String chatID = "";
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        String selection = editor.getSelectionModel().getSelectedText();
        if(selection.length()>4096){

        }
        if (selection == null){
            Messages.showMessageDialog("Selection is empty", "Telegram Post Plagin", Messages.getErrorIcon());
        }
        else {
            chatID = Messages.showInputDialog("Enter your chat ID", "Telegram Post Plagin",
                    Messages.getQuestionIcon(), chatID, null);
            try {
                bot.sendMsg(chatID, editor.getSelectionModel().getSelectedText());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean isDumbAware() {
        return false;
    }
}
