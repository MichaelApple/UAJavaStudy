package notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Miha on 28.07.2017.
 */
public class View {

    // Resource Bundle Installation's
    public static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("ua"));  // Ukrainian
    //new Locale("en"));        // English

    public static final String INPUT_DATA = bundle.getString("input.data");

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWrongInput() {
        System.out.println(bundle.getString("input.error"));
    }

    public void inputData(String input, String regex) {
        System.out.println(INPUT_DATA + " " + input + " (" + regex + "): ");
    }

    public void printUserAlreadyExist(String nickname) {
        printMessage(nickname + bundle.getString("already.exist"));
    }
}
