package coretasks.department;


/**
 * Created by Miha on 09.10.2017.
 */
public abstract class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private int experience;
    private Manager manager;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (this.getExperience() > 2) salary += 200;
        else if (this.getExperience() > 5) salary = salary * 1.2 + 500;
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", manager: " + manager.getLastName() + ", experience " + experience;
    }
}
