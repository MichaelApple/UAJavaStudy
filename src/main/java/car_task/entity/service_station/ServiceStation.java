package car_task.entity.service_station;

import car_task.entity.car.CarMoving;
import car_task.entity.car.Engine;
import car_task.entity.car.RepairEngine;
import car_task.entity.car.RepairMoving;

/**
 * Created by Miha on 17.08.2017.
 */
public class ServiceStation implements RepairEngine, RepairMoving {
    @Override
    public void repairMoving(CarMoving carMoving) {

    }

    @Override
    public void repairEngine(Engine engine) {

    }
}
