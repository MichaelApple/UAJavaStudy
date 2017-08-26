package salary_service.entity.departments;

import org.junit.Test;
import salary_service.entity.employees.Employee;
import salary_service.entity.employees.Manager;
import salary_service.entity.employees.Worker;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Miha on 26.08.2017.
 */
public class DepartmentTest {
    @Test
    public void add() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void changeType() throws Exception {

    }

    @Test
    public void addToManager() throws Exception {
        Manager manager = new Manager("Solo", LocalDate.of(2017, Month.AUGUST, 20), LocalDate.of(1991, Month.MARCH, 18), new ArrayList<>());
        Employee worker = new Worker("Miha", LocalDate.of(2015, Month.AUGUST, 30), LocalDate.of(1992, Month.NOVEMBER, 22));

        AccountingDepartment accountingDepartment = new AccountingDepartment();
        accountingDepartment.addToManager(worker, manager);
        assertNotEquals(0, manager.getSubordinates().size());
    }

    @Test
    public void sortByName() throws Exception {

    }

    @Test
    public void sortByHireDay() throws Exception {

    }

}