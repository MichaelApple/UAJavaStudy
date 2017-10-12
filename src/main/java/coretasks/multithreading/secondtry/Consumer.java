package coretasks.multithreading.secondtry;

/**
 * Created by Miha on 12.10.2017.
 */
public interface Consumer {
    boolean consume(Item j);

    void finishConsumption();
}
