package salary_service.entity;



import salary_service.entity.employees.Employee;

import java.util.List;

/**
 * Created by Miha on 22.08.2017.
 */
public interface SalaryCalculation {
    void  calculateSalaryEquals(List<Employee> employees, long fund);
    void calculateSalaryProportional(List<Employee> employees, long fund);
}
