package salary_service.entity.employees;

import java.time.LocalDate;


/**
 * Created by Miha on 22.08.2017.
 */
public class Worker extends Employee {

    private final long rage = 100;

    public Worker(String name, LocalDate hireDay, LocalDate birthday) {
        super(name, hireDay, birthday);
    }

    @Override
    public long getRage() {
        return rage;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "rage=" + rage +
                '}';
    }
}
