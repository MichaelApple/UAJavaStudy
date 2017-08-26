package salary_service.entity.departments;

import salary_service.entity.employees.Employee;
import salary_service.entity.employees.Manager;
import salary_service.entity.enums.EmployeeType;

import java.util.List;

/**
 * Created by Miha on 26.08.2017.
 */
public interface EmployeeManagement {
    void add(Employee employee);
    void delete(Employee employee);
    Employee changeType(Employee employee, EmployeeType newType);
    void addToManager(Employee employee, Manager manager);
    void sortByName(List<Employee> employees);
    void sortByHireDay(List<Employee> employees);

}
