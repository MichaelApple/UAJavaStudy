package salary_service;

import salary_service.entity.SalaryCalculation;
import salary_service.entity.SalaryCalculator;
import salary_service.entity.employees.Employee;
import salary_service.entity.employees.Manager;
import salary_service.entity.employees.Stuff;
import salary_service.entity.employees.Worker;
import salary_service.entity.departments.AccountingDepartment;
import salary_service.entity.enums.EmployeeType;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 22.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        AccountingDepartment accountingDepartment = new AccountingDepartment();
        SalaryCalculation calculation = new SalaryCalculator();

        Employee worker = new Worker("Miha", LocalDate.of(2015, Month.AUGUST, 30), LocalDate.of(1992, Month.NOVEMBER, 22));
        accountingDepartment.add(new Worker("Miha", LocalDate.of(2015, Month.AUGUST, 30), LocalDate.of(1992, Month.NOVEMBER, 22)));
        accountingDepartment.add(new Manager("Solo", LocalDate.of(2017, Month.AUGUST, 20), LocalDate.of(1991, Month.MARCH, 18), new ArrayList<>()));
        accountingDepartment.add(new Stuff("Sofia", LocalDate.of(2013, Month.APRIL, 7), LocalDate.of(2000, Month.AUGUST, 26), "Some Description"));

        worker = accountingDepartment.changeType(worker, EmployeeType.MANAGER);
        accountingDepartment.add(worker);

        Manager manager = new Manager("Solo", LocalDate.of(2017, Month.AUGUST, 20), LocalDate.of(1991, Month.MARCH, 18), new ArrayList<>());

        accountingDepartment.addToManager(worker, manager);
        System.out.println("!!");
        System.out.println(manager.getSubordinates().toString());

        accountingDepartment.getEmployees().forEach(System.out::println);

        accountingDepartment.setFund();
        System.out.println("Fund " + accountingDepartment.getFund());
        System.out.println();

        calculation.calculateSalaryProportional(accountingDepartment.getEmployees(), accountingDepartment.getFund());

        System.out.println("---------Proportional");
        long summ = 0;
        for (Employee e : accountingDepartment.getEmployees()) {
            summ += e.getSalary();
            System.out.println(e.getSalary());
        }
        System.out.println(summ);
        System.out.println("---------Equal");
        calculation.calculateSalaryEquals(accountingDepartment.getEmployees(), accountingDepartment.getFund());
        summ = 0;
        for (Employee e : accountingDepartment.getEmployees()) {
            summ += e.getSalary();
            System.out.println(e.getSalary());
        }
        System.out.println(summ);
    }
}
