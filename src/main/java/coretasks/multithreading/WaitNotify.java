package coretasks.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Miha on 12.10.2017.
 */
public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        final WaitNotify queue = new WaitNotify();

        Thread t1 = new Thread(() -> {
            try {
                queue.produce(getString());
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

    private static String getString() {
        Scanner sc = new Scanner(System.in);
        String str;

        return sc.nextLine();
    }

    private boolean isEmpty;

    public synchronized void produce(String string) throws InterruptedException {
        while(!isEmpty) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " produce");
        //showLength(string);
        isEmpty = false;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while(isEmpty) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " consume");
        isEmpty = true;
        notify();
    }

//    public static void showLength(String str) {
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted, was calculating length of <" + str + ">");
//            Thread.currentThread().interrupt();
//            return;
//        }
//
//        System.out.println("Length of <" + str + "> is " + str.length());
//    }
}
