package design_patterns.behavioral;

import java.util.Arrays;

/**
 * Created by Miha on 08.08.2017.
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();

        int[] arr = {0, 5, 4, 1, 6, 2, 1};
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(arr);
    }
}

class StrategyClient {
    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr){ strategy.sort(arr);}
}

interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble Sort");
        System.out.println("Before: " + Arrays.toString(arr));
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int i = 0; i < barrier; i++) {
                if (arr[i] > arr[i + 1]){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Selection Sort");
        System.out.println("Before: " + Arrays.toString(arr));
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int i = barrier + 1; i < arr.length; i++) {
                if (arr[i] < arr[barrier]){
                    int tmp = arr[i];
                    arr[i] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Inserting Sort");
        System.out.println("Before: " + Arrays.toString(arr));
        for (int barrier = 1; barrier < arr.length; barrier++) {
            for (int i = barrier + 1; i < arr.length; i++) {
                int index = barrier;
                while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = tmp;
                    index--;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}
