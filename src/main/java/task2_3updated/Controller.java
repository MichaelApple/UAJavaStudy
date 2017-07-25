package task2_3updated;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Miha on 24.07.2017.
 */
public class Controller {

    /**
     * Initial variables
     */
    // Constructor
    Model model;
    View view;
    int guess;
    int min = Model.MIN_BARRIER;
    int max = Model.MAX_BARRIER;
    int guessCount = 0;
    ArrayList<Integer> list = new ArrayList<>();

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * @param min - minimal range number
     * @param max - maximal range number
     * @return Win Number in some range
     */
    public int setRandomNumber(int min, int max) {
        Random random = new Random();
        model.setNumber(random.nextInt(max - min) + min);
        return model.getNumber();
    }

    /**
     * Method that proceed all data from model and user inputs and by using helping methods such as checkInt(Scanner sc),
     * checkWrongNumber(Scanner sc) and method winGame() performs game logic
     */
    // The Work method
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        int winNumber = setRandomNumber(min, max);
        view.printMessage(View.INPUT_INT_DATA);
        checkInt(sc);

        while ((guess = sc.nextInt()) != winNumber) {
            checkWrongNumber(sc);
            if (guess == winNumber) break;
            if (guess > winNumber)
                max = guess;
            else min = guess;

            printNotificationWrongNumber();
            list.add(guess);
            guessCount++;
            checkInt(sc);
        }
        winGame();
    }

    /**
     * @param sc - user input
     *           method get user input and validates it while input data will be entered correct
     */
    public void checkWrongNumber(Scanner sc) {
        while (guess < min || (guess > max)) {
            list.add(guess);
            guessCount++;
            printNotificationWrongNumber();
            checkInt(sc);
            guess = sc.nextInt();
        }
    }

    /**
     * @param sc - user input
     *           method validates input if it`s not a number
     */
    public void checkInt(Scanner sc) {
        while (!sc.hasNextInt()){
            view.printMessage(View.WRONG_INT_INPUT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
    }

    /**
     * Method that will trigger congratulations if user guessed number
     */
    public void winGame() {
        guessCount++;
        list.add(guess);
        view.printMessage(View.YOU_WIN);
        view.printMessage(View.YOUR_GUESS + guess);
        view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
        view.printMessage(View.NUMBER_OF_GUESSES + guessCount);
        view.printListOfGuesses(list);
    }

    /**
     * Method's name speaks for itself )
     */
    private void printNotificationWrongNumber() {
        view.printMessage(View.WRONG_NUMBER);
        view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
        view.printMessage(View.YOUR_GUESS + guess);
    }
}
