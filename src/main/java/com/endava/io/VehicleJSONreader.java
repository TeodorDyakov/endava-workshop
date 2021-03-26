package com.endava.io;

import com.endava.domainModel.Car;
import com.endava.domainModel.Plane;
import com.endava.domainModel.RailedVehicle;
import com.endava.domainModel.Ship;
import com.endava.domainModel.Vehicle;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class VehicleJSONreader {

    public Vehicle readVehicleFromFile(String filePath) {
        Vehicle vehicle = null;
        try {
            var parser = new JsonParser();
            var jsonElement = parser.parse(new FileReader(filePath));
            var jsonObject = jsonElement.getAsJsonObject();

            String vehicleType = jsonObject.get("vehicleType").getAsString();
            var gson = new Gson();

            vehicle = switch (vehicleType) {
                case "CAR" -> gson.fromJson(jsonElement, Car.class);
                case "RAILED" -> gson.fromJson(jsonElement, RailedVehicle.class);
                case "PLANE" -> gson.fromJson(jsonElement, Plane.class);
                case "SHIP" -> gson.fromJson(jsonElement, Ship.class);
                default -> null;
            };

        } catch (FileNotFoundException e) {
            System.out.println("Could not read from file!");
        }
        return vehicle;
    }
}
