package HumanService.entity;

import java.util.Date;

/**
 * Created by Miha on 18.08.2017.
 */
public class Human {
    private String name;
    private String workStatus;

    public Human(String name, String workStatus) {
        this.name = name;
        this.workStatus = workStatus;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", workStatus='" + workStatus + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}
