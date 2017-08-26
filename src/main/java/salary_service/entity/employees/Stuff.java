package salary_service.entity.employees;

import java.time.LocalDate;

/**
 * Created by Miha on 22.08.2017.
 */
public class Stuff extends Employee {

    public static final long rage = 200;

    public Stuff(String name, LocalDate hireDay, LocalDate birthday) {
        super(name, hireDay, birthday);
    }
    @Override
    public long getRage() {
        return rage;
    }
}
