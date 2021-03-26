package com.endava;

import com.endava.domainModel.Car;
import com.endava.domainModel.Engine;
import com.endava.domainModel.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleFinder {
    public List<Vehicle> getAllVehiclesWithPowerMoreThan(List<Vehicle> vehicles, int powerHp) {
        return vehicles.
            stream().
            filter(v -> v.getPowerHP() > powerHp).
            collect(Collectors.toList());
    }

    public List<Vehicle> getAllVehiclesWithGivenEngine(List<Vehicle> vehicles, Engine engine) {
        return vehicles.
            stream().
            filter(v -> v.getEngine().equals(engine)).
            collect(Collectors.toList());
    }

    public List<Vehicle> getAllVehiclesWithGivenModel(List<Vehicle> vehicles, String model) {
        return vehicles.
            stream().
            filter(v -> v.getModel().equals(model)).
            collect(Collectors.toList());
    }

    public List<Vehicle> sortVehiclesByPower(List<Vehicle> vehicles) {
        return vehicles.
            stream().
            sorted(Comparator.comparingInt(Vehicle::getPowerHP)).
            collect(Collectors.toList());
    }

    public List<Car> getCarsOnly(List<Vehicle> vehicles) {
        List<Car> cars = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                cars.add((Car) v);
            }
        }
        return cars;
    }

}
