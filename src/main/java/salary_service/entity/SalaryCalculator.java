package salary_service.entity;

import salary_service.entity.employees.Employee;
import salary_service.entity.employees.Manager;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Miha on 26.08.2017.
 */
public class SalaryCalculator implements SalaryCalculation {
    @Override
    public void calculateSalaryEquals(List<Employee> employees, long fund) {
        long summ = 0;
        for (Employee e : employees) {
            e.setSalary(e.getRage() + (checkBirthday(LocalDate.now(), e.getBirthday()) ? SalaryStuff.BIRTHDAY_PREMIUM : 0) + (e.getClass().equals(Manager.class) ? SalaryStuff.MANAGER_PREMIUM_PER_WORKER : 0));
            summ += e.getSalary();
        }
        long part = (fund - summ) / employees.size();
        employees.forEach(employee -> employee.setSalary(employee.getSalary() + part));

    }

    @Override
    public void calculateSalaryProportional(List<Employee> employees, long fund) {
        long summ = 0;
        for (Employee e : employees) {
            e.setSalary(e.getRage() + (checkBirthday(LocalDate.now(), e.getBirthday()) ? SalaryStuff.BIRTHDAY_PREMIUM : 0) + (e.getClass().equals(Manager.class) ? SalaryStuff.MANAGER_PREMIUM_PER_WORKER : 0));
            summ += e.getSalary();
        }
        long remain = (fund - summ);
        for (Employee e : employees) {
            //System.out.println(e.getSalary());
            double part = (double) summ / (double) e.getSalary();
            double bonus = remain / part;
            e.setSalary(e.getSalary() + (long) bonus);
        }
    }

    private boolean checkBirthday(LocalDate currentDate, LocalDate birthday) {
        return currentDate.getMonth() == birthday.getMonth() & currentDate.getDayOfMonth() == birthday.getDayOfMonth();
    }
}
