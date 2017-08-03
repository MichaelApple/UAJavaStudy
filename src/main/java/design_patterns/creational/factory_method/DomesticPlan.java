package design_patterns.creational.factory_method;

/**
 * Created by Miha on 03.08.2017.
 */
public class DomesticPlan extends Plan {
    @Override
    void getRate() {
        rate = 3.50;
    }
}
