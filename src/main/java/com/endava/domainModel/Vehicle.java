package com.endava.domainModel;

import java.util.Objects;

public abstract class Vehicle {

    protected Engine engine;
    protected String model;
    protected int powerHP;
    protected String registrationNumber;

    public Vehicle(Engine engine, String model, int powerHP, String registrationNumber) {
        this.engine = engine;
        this.model = model;
        this.powerHP = powerHP;
        this.registrationNumber = registrationNumber;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }

    public int getPowerHP() {
        return powerHP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return registrationNumber.equals(vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
