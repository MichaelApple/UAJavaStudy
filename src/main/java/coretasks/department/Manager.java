package coretasks.department;

import java.util.ArrayList;

/**
 * Created by Miha on 09.10.2017.
 */
public class Manager extends Employee {
    private ArrayList<Employee> team;

    public ArrayList<Employee> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Employee> team) {
        this.team = team;
    }

    @Override
    public double getSalary() {
        int bonus = 0;
        int devCount = 0;

        if (team.size() > 5 && team.size() < 10) bonus = 200;
        else if (team.size() > 10) bonus = 300;

        for (Employee employee : team) {
            if (employee instanceof Developer) devCount++;
        }
        if (devCount > team.size() / 2) return super.getSalary() * 1.1;

        return super.getSalary() +  bonus;
    }
}
