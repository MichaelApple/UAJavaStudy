package design_patterns.creational.singleton;

/**
 * Created by Miha on 03.08.2017.
 */
public class SingletonLazyInit {

    private static SingletonLazyInit obj;
    private SingletonLazyInit() {}

    public static SingletonLazyInit getInstance() {
        if (obj == null) {
            obj = new SingletonLazyInit();
        }
        return obj;
    }
}
