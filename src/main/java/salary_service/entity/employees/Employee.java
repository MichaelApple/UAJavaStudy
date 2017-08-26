package salary_service.entity.employees;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Miha on 22.08.2017.
 */
public abstract class Employee {
    private String name;
    private long salary;
    private LocalDate hireDay;
    private LocalDate birthday;
    protected long rage;
    public Employee(String name, LocalDate hireDay, LocalDate birthday) {
        this.name = name;
        this.hireDay = hireDay;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public abstract long getRage();

}
