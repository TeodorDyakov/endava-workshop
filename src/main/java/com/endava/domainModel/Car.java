package com.endava.domainModel;

public class Car extends Vehicle {

    private CarType type;
    private int topSpeed;

    public Car(Engine engine, String model, int powerHP, CarType type, int topSpeed, String registrationNumber) {
        super(engine, model, powerHP, registrationNumber);
        this.type = type;
        this.topSpeed = topSpeed;
    }

    public int getTopSpeed() {
        return this.topSpeed;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
            "type=" + type +
            ", topSpeed=" + topSpeed +
            ", engine=" + engine +
            ", model='" + model + '\'' +
            ", powerHP=" + powerHP +
            ", registrationNumber='" + registrationNumber + '\'' +
            '}';
    }
}
