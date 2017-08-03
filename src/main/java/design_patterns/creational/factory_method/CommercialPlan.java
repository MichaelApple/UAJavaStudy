package design_patterns.creational.factory_method;

/**
 * Created by Miha on 03.08.2017.
 */
public class CommercialPlan extends Plan {
    @Override
    void getRate() {
        rate = 7.50;
    }
}
