package multithreading;

import multithreading.students.Biologists;
import multithreading.students.Mathematics;
import multithreading.students.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Miha on 12.09.2017.
 */
public class Main {

    public static void main(String[] args) {
        Queue<Student> students = new ConcurrentLinkedQueue<>();

        Queue<Student> mathematics = new LinkedList<>();
        for (int i = 0; i < 250; i++) {
            mathematics.add(new Mathematics());
        }
        Queue<Student> biologists = new LinkedList<>();
        for (int i = 0; i < 200; i++) {
            biologists.add(new Biologists());
        }

        for (int i = 0; i < 50; i++) {
            students.add(Math.random() < 0.5 ? mathematics.poll() : biologists.poll());
        }

        System.out.println(students.size());
        //students.forEach(System.out::println);

        Runnable bioUniversity = () -> {
            synchronized (students) {
                for (Student student : students) {
                    if (student instanceof Biologists) {
                        students.poll();
                    } else break;
                    if (students.size() < 25) addRandom(students, mathematics, biologists);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable randomUniversity = () -> {
            synchronized (students) {
                int i = ThreadLocalRandom.current().nextInt(1, 5);
                for (int j = 0; j < i; j++) {
                    students.poll();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable mathUniversity = () -> {
            synchronized (students) {
                for (Student student : students) {
                    if (student instanceof Mathematics) {
                        students.poll();
                    } else break;
                    if (students.size() < 25) addRandom(students, mathematics, biologists);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        while (biologists.size() != 0 && mathematics.size() != 0) {
            bioUniversity.run();
            randomUniversity.run();
            mathUniversity.run();
        }


        System.out.println(students.size());
    }

    private static Queue<Student> addRandom(Queue<Student> students, Queue<Student> mathematics, Queue<Student> biologists) {
        while (students.size() < 50) {
            students.add(Math.random() < 0.5 ? mathematics.poll() : biologists.poll());
        }
        return students;
    }
}
