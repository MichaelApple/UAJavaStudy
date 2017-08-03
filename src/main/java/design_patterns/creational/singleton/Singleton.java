package design_patterns.creational.singleton;

/**
 * Created by Miha on 03.08.2017.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
