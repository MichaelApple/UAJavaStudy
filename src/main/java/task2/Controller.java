package task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Miha on 24.07.2017.
 */
public class Controller {

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

    public int setRandomNumber(int min, int max) {
        Random random = new Random();
        model.setNumber(random.nextInt(max - min) + min);
        return model.getNumber();
    }

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

            view.printMessage(View.WRONG_NUMBER);
            view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
            view.printMessage(View.YOUR_GUESS + guess);
            list.add(guess);
            guessCount++;
            checkInt(sc);
        }
        winGame();
    }

    public void checkWrongNumber(Scanner sc) {
        while (guess < min || (guess > max)) {
            list.add(guess);
            guessCount++;
            view.printMessage(View.WRONG_NUMBER);
            view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
            view.printMessage(View.YOUR_GUESS + guess);
            checkInt(sc);
            guess = sc.nextInt();
        }
    }

    public void checkInt(Scanner sc) {
        while (!sc.hasNextInt()){
            view.printMessage(View.WRONG_INT_INPUT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
    }

    public void winGame() {
        guessCount++;
        list.add(guess);
        view.printMessage(View.YOU_WIN);
        view.printMessage(View.YOUR_GUESS + guess);
        view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
        view.printMessage(View.NUMBER_OF_GUESSES + guessCount);
        view.printListOfGuesses(list);
    }
}
