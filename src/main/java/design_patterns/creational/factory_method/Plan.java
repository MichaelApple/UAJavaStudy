package design_patterns.creational.factory_method;

/**
 * Created by Miha on 03.08.2017.
 */
public abstract class Plan {
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}
