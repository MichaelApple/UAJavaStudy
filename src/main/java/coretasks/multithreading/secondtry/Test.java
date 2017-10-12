package coretasks.multithreading.secondtry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

/**
 * Created by Miha on 12.10.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {

        Consumer consumer = new ConsumerImpl(5);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line = br.readLine()) != null && !(line.equals("!quit"))) {
            if (line.equals("!quit")) System.exit(0);
            consumer.consume(new PrintJob(line));
        }
        consumer.finishConsumption();
    }
}

class PrintJob implements Item {
    private String line;

    public PrintJob(String s) {
        line = s;
    }

    public void process() {
        showLength(line);
        System.out.println(Thread.currentThread().getName() + " consuming :" + line);
    }

    public static void showLength(String str) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted, was calculating length of <" + str + ">");
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("Length of <" + str + "> is " + str.length());
    }
}