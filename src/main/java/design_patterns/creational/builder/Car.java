package design_patterns.creational.builder;

/**
 * Created by Miha on 03.08.2017.
 */
enum Transmission {
    AUTO, MANUAL
}

public class Car {
    String name;
    Transmission transmission;
    int maxSpeed;

    public void setName(String name) {
        this.name = name;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

class CarBuilder {
    String name = "Default";
    Transmission transmission = Transmission.MANUAL;
    int maxSpeed = 160;

    CarBuilder buildName(String name) {
        this.name = name;
        return this;
    }
    CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setName(name);
        car.setTransmission(transmission);
        car.setMaxSpeed(maxSpeed);
        return car;
    }
}
