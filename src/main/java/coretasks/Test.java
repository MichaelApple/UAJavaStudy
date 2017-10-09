package coretasks;

import java.util.*;

/**
 * Created by Miha on 09.10.2017.
 */
public class Test {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.multiply(1,2,3,4));

        System.out.println(test.reverse("I am testing"));
        System.out.println(test.is_palindrome("radar"));

        test.histogram(4, 9, 7);

        int[][] forward = {
                { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9}
        };

        test.diaginal_reverse(forward);

        System.out.println();
        System.out.println(test.isBracketBalanced("[]"));

        System.out.println();
        for (Map.Entry<Character, Integer> entry : test.char_freq("abbabcbdbabdbdbabababcbcbab").entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

        System.out.println();
        test.dec_to_bin(10);

    }

   /**
   * 1 Task
    */
    public void printString(String string) {
        System.out.println("Hello, " + string + "!");
    }
    /**
     * 2 Task
     */
    public int sum(int ... list) {
        int result = 0;
        for (int number : list) {
            result += number;
        }
        return result;
    }
    /**
     * 2 Task
     */
    public int multiply(int ... list) {
        int result = 1;
        for (int number : list) {
            result *= number;
        }
        return result;
    }

    /**
     * 3 Task
     */
    public String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    /**
     * 4 Task
     */
    public boolean is_palindrome(String string) {
        String reverse = reverse(string);
        return string.equals(reverse);
    }

    /**
     * 5 Task
     */
    public void histogram(int ... list) {
        for (int item : list) {
            for (int j = 0; j < item; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 6 Task
     */
    public String caesar_cipher(String plainText, int shiftKey) {
        plainText = plainText.toLowerCase();

        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++){
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    /**
     * 7 Task
     */
    public int[][] diaginal_reverse(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] reverse = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                reverse[i][j] = matrix[j][i];
            }
        }

        // Added for visualisation
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(reverse[i][j]);
                if(j < cols-1)
                    System.out.print(", ");
            }
            System.out.println();
        }

        return reverse;
    }

    /**
     * 9 Task
     */
    public boolean isBracketBalanced(String str) {

        boolean isBalanced = false;
        if (str.charAt(0) != '[')
            return false;

        Stack<Character> stack = new Stack<>();

        char c;
        for(int i=0; i < str.length(); i++) {
            c = str.charAt(i);

            if(c == '[')
                stack.push(c);
            else if(c == ']')
                if(stack.empty())
                    return false;
                else if(stack.peek() == '[')
                    stack.pop();
                else
                    return false;
        }
        return stack.empty();
    }

    /**
     * 10 Task
     */
    public HashMap<Character,Integer> char_freq(String string) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            Integer val = map.get(c);
            if (val != null)
                map.put(c, val + 1);
            else
                map.put(c,1);

        }
        return map;
    }

    /**
     * 11 Task
     */
    public void dec_to_bin(int number) {
        int binary[] = new int[25];
        int index = 0;
        while(number > 0){
            binary[index++] = number % 2;
            number = number / 2;
        }
        for(int i = index-1; i >= 0; i--){
            System.out.print(binary[i]);
        }
    }
}
