package com.endava.domainModel;

public class RailedVehicle extends Vehicle {
    RailedVehicleType type;
    int railSizeMM;

    public RailedVehicle(Engine engine, String model, int powerHP, RailedVehicleType type, int railSizeMM) {
        super(engine, model, powerHP);
        this.railSizeMM = railSizeMM;
        this.type = type;
    }

    public RailedVehicleType getType() {
        return type;
    }

    public void setType(RailedVehicleType type) {
        this.type = type;
    }

}
