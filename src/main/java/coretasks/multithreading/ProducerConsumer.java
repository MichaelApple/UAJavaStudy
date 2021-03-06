package coretasks.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Miha on 12.10.2017.
 */
public class ProducerConsumer {

    static final Queue<String> queue = new LinkedList();
    static int MAX_SIZE = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_SIZE) {
                        System.out.println("Waiting for consumer to consume.");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                    String line = null;
                    try {
                        line = br.readLine();
                        if (line.equals("!quit")) System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Producer " + line);
                    queue.add(line);
                    queue.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println("Waiting for producer to produce.");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String element = queue.poll();
                    showLength(element);
                    queue.notifyAll();
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void showLength(String str) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Interrupted, was calculating length of <" + str + ">");
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("Length of <" + str + "> is " + str.length());
    }
}
