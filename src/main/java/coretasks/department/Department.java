package coretasks.department;

import java.util.ArrayList;

/**
 * Created by Miha on 09.10.2017.
 */
public class Department {
    private ArrayList<Manager> managers;

    private void salary(Employee employee) {
        System.out.println(employee.getFirstName() + " " + employee.getLastName() + ": got salary: " + employee.getSalary());
    }
}
