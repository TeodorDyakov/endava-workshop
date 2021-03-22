package com.endava;

import com.endava.domainModel.Car;
import com.endava.domainModel.RailedVehicle;
import com.endava.domainModel.Vehicle;
import com.endava.io.VehicleJSONreader;
import com.endava.parking.AirplaneParking;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        var vehicleJSONreader = new VehicleJSONreader();

        Vehicle vehicle1 = vehicleJSONreader.readVehicleFromFile("plane.json");
        Vehicle vehicle2 = vehicleJSONreader.readVehicleFromFile("ship.json");

        Car car = (Car) vehicleJSONreader.readVehicleFromFile("car.json");
        RailedVehicle metro = (RailedVehicle) vehicleJSONreader.readVehicleFromFile("metro.json");

        System.out.println(car);
        System.out.println(metro);

        System.out.println(vehicle1);
        System.out.println(vehicle2);
        AirplaneParking parking = new AirplaneParking(2, new PaymentProcessor(), new BigDecimal(10));
        boolean carEntered = parking.enterVehicle(car);
        System.out.println(carEntered);
    }
}
