package com.endava;

import com.endava.domainModel.Car;
import com.endava.domainModel.Plane;
import com.endava.domainModel.RailedVehicle;
import com.endava.domainModel.Ship;
import com.endava.io.VehicleJSONreader;
import com.endava.parking.AirplaneParking;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        var vehicleJSONreader = new VehicleJSONreader();

        Ship ship = (Ship) vehicleJSONreader.readVehicleFromFile("ship.json");
        Car car = (Car) vehicleJSONreader.readVehicleFromFile("car.json");
        RailedVehicle metro = (RailedVehicle) vehicleJSONreader.readVehicleFromFile("metro.json");
        Plane plane = (Plane) vehicleJSONreader.readVehicleFromFile("plane.json");

        System.out.println(car);
        System.out.println(metro);
        System.out.println(ship);
        System.out.println(plane);

        AirplaneParking parking = new AirplaneParking(2, new PaymentProcessor(), new BigDecimal(10));
        boolean carEntered = parking.enterVehicle(car);
        if (carEntered) {
            System.out.println("car entered parking");
        }

        Repository repository = new Repository();
        boolean saved = repository.saveCar(car);

        if (saved) {
            System.out.println("the car object was written to database");
        }

        saved = repository.saveShip(ship);

        if (saved) {
            System.out.println("the ship object was written to database");
        }
    }
}


//    INSERT INTO `cars` (`type`, `model`, `engine`, `powerHP`, `topSpeed`, `regitstrationNumber`) VALUES ('HATCHBACK', 'GOlf 6', 'INTERNAL_COMBUSTION', '80', '200', 'СА5678ПО');