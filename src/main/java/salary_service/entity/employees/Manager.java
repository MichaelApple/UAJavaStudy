package salary_service.entity.employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 22.08.2017.
 */
public class Manager extends Employee {

    private final long rage = 500;

    private List<Employee> subordinates = new ArrayList<>();
    @Override
    public long getRage() {
        return rage;
    }

    public Manager(String name, LocalDate hireDay, LocalDate birthday, List<Employee> subordinates) {
        super(name, hireDay, birthday);
        this.subordinates = subordinates;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "rage=" + rage +
                ", subordinates=" + subordinates.size() +
                '}';
    }
}
