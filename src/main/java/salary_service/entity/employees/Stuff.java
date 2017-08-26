package salary_service.entity.employees;

import java.time.LocalDate;

/**
 * Created by Miha on 22.08.2017.
 */
public class Stuff extends Employee {

    private final long rage = 200;
    private String description;

    public Stuff(String name, LocalDate hireDay, LocalDate birthday, String description) {
        super(name, hireDay, birthday);
        this.description = description;
    }
    @Override
    public long getRage() {
        return rage;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "rage=" + rage +
                ", description='" + description + '\'' +
                '}';
    }
}
