package task2;

import java.util.ArrayList;

/**
 * Created by Miha on 24.07.2017.
 */
public class View {
    // Text's constants

    public static final String WRONG_INPUT_DATA = "Your input is slightly far from right range of numbers. Try again. ";
    public static final String WRONG_INT_INPUT_DATA = "Your input is not a number. Try again. ";
    public static final String INPUT_INT_DATA = "Guess your number: ";
    public static final String INPUT_NEXT_GUESS = "Your next guess is: ";
    public static final String YOU_WIN = "Your number wins!!!";
    public static final String NEXT_RANGE = "Next range is: ";
    public static final String YOUR_GUESS = "Your guess was: ";
    public static final String RANGE_OF_NUMBERS = "Current range of numbers is: ";
    public static final String WRONG_NUMBER = "Your number did not match with WinNumber or it is out of range. Try again: ";
    public static final String NUMBER_OF_GUESSES = "Total number of guesses: ";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printListOfGuesses(ArrayList<Integer> list) {
        System.out.println();
        System.out.println("List of all your guesses: ");
        for (Integer i : list) {
            System.out.println(YOUR_GUESS + i);
        }
    }

}
