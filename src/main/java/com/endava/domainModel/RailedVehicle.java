package com.endava.domainModel;

public class RailedVehicle extends Vehicle {
    private RailedVehicleType type;
    private int railSizeMM;

    public RailedVehicle(Engine engine, String model, int powerHP, RailedVehicleType type, int railSizeMM,
                         String registrationNumber) {
        super(engine, model, powerHP, registrationNumber);
        this.railSizeMM = railSizeMM;
        this.type = type;
    }

    public RailedVehicleType getType() {
        return type;
    }

    public int getRailSizeMM() {
        return railSizeMM;
    }

    @Override
    public String toString() {
        return "RailedVehicle{" +
            "type=" + type +
            ", railSizeMM=" + railSizeMM +
            ", engine=" + engine +
            ", model='" + model + '\'' +
            ", powerHP=" + powerHP +
            ", registrationNumber='" + registrationNumber + '\'' +
            '}';
    }
}
