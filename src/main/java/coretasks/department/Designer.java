package coretasks.department;

/**
 * Created by Miha on 09.10.2017.
 */
public class Designer extends Employee {
    private int effectivnessCoefficient;

    public int getEffectivnessCoefficient() {
        return effectivnessCoefficient;
    }

    public void setEffectivnessCoefficient(int effectivnessCoefficient) {
        this.effectivnessCoefficient = effectivnessCoefficient;
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(salary * getEffectivnessCoefficient());
    }
}
