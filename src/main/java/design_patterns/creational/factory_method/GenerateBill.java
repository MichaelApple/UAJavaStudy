package design_patterns.creational.factory_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Miha on 03.08.2017.
 */
public class GenerateBill {
    public static void main(String[] args) throws IOException {
        GetPlanFactory factory = new GetPlanFactory();

        System.out.println("Enter the name of plan: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String planName = reader.readLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units = Integer.parseInt(reader.readLine());

        Plan plan = factory.getPlan(planName);

        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");

        plan.getRate();
        plan.calculateBill(units);
    }
}
