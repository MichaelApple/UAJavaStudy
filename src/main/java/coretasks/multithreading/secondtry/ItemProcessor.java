package coretasks.multithreading.secondtry;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ItemProcessor implements Runnable {
    private BlockingQueue< Item> jobQueue;

    private volatile boolean keepProcessing;

    public ItemProcessor(BlockingQueue<Item> queue) {
        jobQueue = queue;
        keepProcessing = true;
    }

    public void run(){
        while(keepProcessing || !jobQueue.isEmpty()) {
            try {
                Item j = jobQueue.poll(5, TimeUnit.SECONDS);
                if(j != null)
                    j.process();
            }
            catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void cancelExecution() {
        this.keepProcessing = false;
    }
}
