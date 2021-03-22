package com.endava.domainModel;

public class Ship extends Vehicle {

    private ShipType type;
    private int cargoVolume;

    public Ship(Engine engine, String model, int powerHP, ShipType type, int cargoVolume, String registrationNumber) {
        super(engine, model, powerHP, registrationNumber);
        this.type = type;
        this.cargoVolume = cargoVolume;
    }

    public ShipType getType() {
        return type;
    }

    public int getCargoVolume() {
        return cargoVolume;
    }

    @Override
    public String toString() {
        return "Ship{" +
            "type=" + type +
            ", cargoVolume=" + cargoVolume +
            ", engine=" + engine +
            ", model='" + model + '\'' +
            ", powerHP=" + powerHP +
            ", registrationNumber='" + registrationNumber + '\'' +
            '}';
    }
}
