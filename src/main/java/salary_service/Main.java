package salary_service;

import salary_service.entity.SalaryCalculation;
import salary_service.entity.SalaryCalculator;
import salary_service.entity.employees.Employee;
import salary_service.entity.employees.Manager;
import salary_service.entity.employees.Stuff;
import salary_service.entity.employees.Worker;
import salary_service.model.AccountingDepartment;

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

        List<Employee> employees = new ArrayList<>();
        {
            employees.add(new Worker("Miha", LocalDate.of(2015, Month.AUGUST, 30), LocalDate.of(1992, Month.NOVEMBER, 22)));
            employees.add(new Manager("Solo", LocalDate.of(2017, Month.AUGUST, 20), LocalDate.of(1991, Month.MARCH, 18)));
            employees.add(new Stuff("Sofia", LocalDate.of(2013, Month.APRIL, 7), LocalDate.of(2000, Month.AUGUST, 26)));
        }
        accountingDepartment.setEmployees(employees);

        accountingDepartment.setFund();
        System.out.println(accountingDepartment.getFund());
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
