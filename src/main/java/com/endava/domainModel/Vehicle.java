package com.endava.domainModel;

public abstract class Vehicle {
    Engine engine;
    String model;
    int powerHP;

    public Vehicle(Engine engine, String model, int powerHP) {
        this.engine = engine;
        this.model = model;
        this.powerHP = powerHP;
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
    public String toString() {
        return "Vehicle{" +
            "engine=" + engine +
            ", model='" + model + '\'' +
            ", powerHP=" + powerHP +
            '}';
    }

}
