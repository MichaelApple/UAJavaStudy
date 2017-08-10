package patterns_tasks;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Miha on 10.08.2017.
 */
public class Tourist {
    public static void main(String[] args) {
        Vacation vacation = new Vacation();
        vacation.addOption(new Transfer());
        vacation.addOption(new FlyTickets());
        vacation.addOption(new HotelBooking());
        
        vacation.info();
    }
}

abstract class Option {
    private boolean isIncluded = false;

    public void includeOption() {
        this.isIncluded = true;
    }
    public boolean isIncluded() {
        return isIncluded;
    }
    abstract void info();
}

class Transfer extends Option {
    @Override
    void info() {
        System.out.println(isIncluded() ? "Transfer is included" : "Transfer is not included");
    }
}

class FlyTickets extends Option {
    @Override
    void info() {
        System.out.println(isIncluded() ? "FlyTickets is included" : "FlyTickets is not included");
    }
}
class HotelBooking extends Option {
    @Override
    void info() {
        System.out.println(isIncluded() ? "Hotel Booking is included" : "Hotel Booking is not included");
    }
}

class Insurance extends Option {
    @Override
    void info() {
        System.out.println(isIncluded() ? "Insurance is included" : "Insurance is not included");
    }
}

class Vacation extends Option {

    private Set<Option> options = new HashSet<>();

    public void addOption(Option option) {
        options.add(option);
    }
    public void removeOption(Option option) {
        options.remove(option);
    }

    public void includeOption() {
        for (Option o : options)
            o.includeOption();
    }

    @Override
    void info() {
        for (Option o : options)
            o.info();
    }
}
