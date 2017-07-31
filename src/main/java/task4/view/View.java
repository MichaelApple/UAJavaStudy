package task4.view;

/**
 * Created by Miha on 28.07.2017.
 */
public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWrongInput() {
        System.out.println("Inputted data is incorrect!");
    }

    public void inputData(String input, String regex) {
        System.out.println("Please enter " + input + " (" + regex + "): ");
    }

    public void printUserAlreadyExist(String nickname) {
        printMessage(nickname + " already exists. Try another one.");
    }
}
