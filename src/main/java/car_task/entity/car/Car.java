package car_task.entity.car;


/**
 * Created by Miha on 17.08.2017.
 */
public class Car {
    private String name;
    private Engine engine;
    private CarMoving carMoving;
    private Fuel fuel;
    private Wheel wheel;
    private Glass glass;

    public void setName(String name) {
        this.name = name;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public void setCarMoving(CarMoving carMoving) {
        this.carMoving = carMoving;
    }
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
    public void setGlass(Glass glass) {
        this.glass = glass;
    }


    class CarBuilder {
        private String name;
        private Engine engine;
        private CarMoving carMoving;
        private Fuel fuel;
        private Wheel wheel;
        private Glass glass;

        CarBuilder buildName(String name) {
            this.name = name;
            return this;
        }
        CarBuilder buildMoving(CarMoving carMoving) {
            this.carMoving = carMoving;
            return this;
        }
        CarBuilder buildEngine(Engine engine) {
            this.engine = engine;
            return this;
        }
        CarBuilder buildFuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }
        CarBuilder buildWheel(Wheel Wheel) {
            this.wheel = wheel;
            return this;
        }
        CarBuilder buildGlass(Glass Glass) {
            this.glass = glass;
            return this;
        }
    }

    /**
     * Created by Miha on 17.08.2017.
     */
    public static enum Fuel {
        A92, A95, A98, DP
    }

    /**
     * Created by Miha on 17.08.2017.
     */
    public static enum Glass {
        FRONTAL, DRIVER, FRONT_PASSANGER, LEFT_PASSANGER, RIGHT_PASSANGER, BACK
    }

    /**
     * Created by Miha on 17.08.2017.
     */
    public static enum Wheel {
        FEFT_FRONTAL, RIGHT_FRONTAL, LEFT_BACK, RIGHT_BACK
    }
}

