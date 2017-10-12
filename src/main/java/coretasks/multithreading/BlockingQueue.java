package coretasks.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Miha on 12.10.2017.
 */
public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue queue = new BlockingQueue(1);
        Scanner sc = new Scanner(System.in);

        Thread t1 = new Thread(() -> {
            String str = sc.nextLine();
            while (!(str).equals("!quit"))
            try {
                queue.produce("String");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                queue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String element) throws InterruptedException {
        while(queue.size() == capacity) {
            wait();
        }
        showLength(element);
        queue.add(element);
        System.out.println(Thread.currentThread().getName() + " produce");
        notify();
    }

    public synchronized String consume() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }

        String string = queue.remove();
        System.out.println(Thread.currentThread().getName() + " consume");
        notify();
        return string;
    }

    public static void showLength(String str) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted, was calculating length of <" + str + ">");
//            Thread.currentThread().interrupt();
//            return;
//        }

        System.out.println("Length of <" + str + "> is " + str.length());
    }
}
