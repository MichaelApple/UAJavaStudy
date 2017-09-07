package salary_service.entity.departments;

import salary_service.entity.employees.Employee;
import salary_service.entity.employees.Manager;
import salary_service.entity.employees.Stuff;
import salary_service.entity.employees.Worker;
import salary_service.entity.enums.EmployeeType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Miha on 26.08.2017.
 */
public class Department implements EmployeeManagement {
    protected List<Employee> employees = new ArrayList<>();
    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void delete(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Employee changeType(Employee employee, EmployeeType newType) {

        switch (newType) {
            case MANAGER:
                return new Manager(employee.getName(), employee.getHireDay(), employee.getBirthday(), new ArrayList<>());

            case STUFF: return new Stuff(employee.getName(), employee.getHireDay(), employee.getBirthday(), "New Stuff worker");
            default: return new Worker(employee.getName(), employee.getHireDay(), employee.getBirthday());
        }
    }

    @Override
    public void addToManager(Employee employee, Manager manager) {
        manager.getSubordinates().add(employee);
    }

    @Override
    public void sortByName(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getName));
    }

    @Override
    public void sortByHireDay(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getHireDay));
    }
}
