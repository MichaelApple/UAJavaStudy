package coretasks;

import moreless.View;

import java.util.Random;
import java.util.Scanner;

/**
 * 8 Task
 */
public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.game(0, 10);
    }

    int guess;

   public void game(int min, int max) {
       Scanner sc = new Scanner(System.in);
       int winNumber = setRandomNumber(min, max);
       checkInt(sc);

       while ((guess = sc.nextInt()) != winNumber) {
           while (guess < min || (guess > max)) {
               System.out.println("You didn't guess. Current range is: " + min + ": " + max);
               checkInt(sc);
               guess = sc.nextInt();
           }
           if (guess == winNumber) break;
           if (guess > winNumber)
               max = guess;
           else min = guess;
           System.out.println("You didn't guess. Current range is: " + min + ": " + max);
           checkInt(sc);
       }
       System.out.println("You win!!! Number was: " + winNumber);
       System.out.println("Your guess: " + guess);

   }


    private int setRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private void checkInt(Scanner sc) {
        while (!sc.hasNextInt()){
            System.out.println("Your input is not a number");
            sc.next();
        }
    }

}
