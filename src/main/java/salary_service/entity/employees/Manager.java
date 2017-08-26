package salary_service.entity.employees;

import java.time.LocalDate;

/**
 * Created by Miha on 22.08.2017.
 */
public class Manager extends Employee {

    public final long rage = 500;

    @Override
    public long getRage() {
        return rage;
    }

    public Manager(String name, LocalDate hireDay, LocalDate birthday) {
        super(name, hireDay, birthday);
    }
}
