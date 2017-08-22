package car_task.entity.refuel_station;

import car_task.entity.car.Car;
import car_task.entity.car.CleanGlass;
import car_task.entity.car.PumpWheel;
import car_task.entity.car.RefuelCar;

/**
 * Created by Miha on 17.08.2017.
 */
public class FuelStation implements PumpWheel, CleanGlass, RefuelCar {
    @Override
    public void pumpWheel(Car.Wheel wheel) {
        System.out.println("Pumping wheel");
    }

    @Override
    public void cleanGlass(Car.Glass glass) {

    }

    @Override
    public void chooseFuel(Car.Fuel fuel) {

    }
}
