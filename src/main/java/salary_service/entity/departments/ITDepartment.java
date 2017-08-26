package salary_service.entity.departments;

import salary_service.entity.employees.Employee;
import salary_service.utils.FundUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 26.08.2017.
 */
public class ITDepartment extends Department {
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
