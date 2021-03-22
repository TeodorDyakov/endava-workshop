package com.endava.domainModel;

public class Plane extends Vehicle {

    private PlaneType type;
    private int numberOfEngines;

    public Plane(Engine engine, String model, int powerHP, PlaneType type, int numberOfEngines, String registrationNumber) {
        super(engine, model, powerHP, registrationNumber);
        this.numberOfEngines = numberOfEngines;
        this.type = type;
    }

    public PlaneType getType() {
        return type;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    @Override
    public String toString() {
        return "Plane{" +
            "type=" + type +
            ", numberOfEngines=" + numberOfEngines +
            ", engine=" + engine +
            ", model='" + model + '\'' +
            ", powerHP=" + powerHP +
            ", registrationNumber='" + registrationNumber + '\'' +
            '}';
    }
}
