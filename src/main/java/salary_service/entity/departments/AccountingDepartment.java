package salary_service.entity.departments;


import salary_service.entity.*;
import salary_service.entity.employees.Employee;
import salary_service.utils.FundUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 22.08.2017.
 */
public class AccountingDepartment extends Department {

    private long fund;

    public void setFund() {
        this.fund = 0;
        employees.forEach(employee -> this.fund += employee.getRage());
        this.fund = fund + FundUtils.getRandomNumberInRange(200, 400);
    }
    public long getFund() {
        return fund;
    }
    public List<Employee> getEmployees() {
        return super.employees;
    }
}
