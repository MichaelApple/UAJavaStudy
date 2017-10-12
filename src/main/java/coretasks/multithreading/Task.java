package coretasks.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Miha on 12.10.2017.
 */
public class Task {

    public static void main(String args[]) {
        System.out.println("How to use wait and notify method in Java");
        System.out.println("Solving Producer Consumer Problem");

        Queue<String> buffer = new LinkedList<>();
        int maxSize = 10;

        Thread producer = new Producer(buffer, maxSize, "PRODUCER");
        Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");

        producer.start();
        consumer.start();
    }


}

    class Producer extends Thread {
        private Queue<String> queue;
        private int maxSize;

        public Producer(Queue<String> queue, int maxSize, String name){
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            System.out .println("Queue is full, "
                                    + "Producer thread waiting for "
                                    + "consumer to take something from queue");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("Producing value : " + i);
                    queue.add(String.valueOf(i));
                    queue.notifyAll();
                }

            }
        }
    }


    class Consumer extends Thread {
        private Queue<String> queue;
        private int maxSize;

        public Consumer(Queue<String> queue, int maxSize, String name) {
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty,"
                                + "Consumer thread is waiting"
                                + " for producer thread to put something in queue");
                        try {
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                    System.out.println("Consuming value : " + queue.remove());
                    queue.notifyAll();
                }

            }
        }

//        public static void showLength(String str) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted, was calculating length of <" + str + ">");
//                Thread.currentThread().interrupt();
//                return;
//            }
//
//            System.out.println("Length of <" + str + "> is " + str.length());
//        }
    }




