package com.endava.io;

import com.endava.domainModel.Car;
import com.endava.domainModel.CarType;
import com.endava.domainModel.Engine;
import com.endava.domainModel.Plane;
import com.endava.domainModel.PlaneType;
import com.endava.domainModel.RailedVehicle;
import com.endava.domainModel.RailedVehicleType;
import com.endava.domainModel.Ship;
import com.endava.domainModel.ShipType;
import com.endava.domainModel.Vehicle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class VehicleJSONreader {

    public Vehicle readVehicleFromFile(String filePath) {
        Vehicle vehicle = null;
        try {
            JsonObject jsonObject;
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(filePath));
            jsonObject = jsonElement.getAsJsonObject();

            String engineType = jsonObject.get("engine").getAsString();
            Engine engine = Engine.engineMap.get(engineType);
            String registrationNumber = jsonObject.get("registrationNumber").getAsString();

            final String vehicleType = jsonObject.get("vehicleType").getAsString();
            int powerHp = jsonObject.get("powerHP").getAsInt();
            String model = jsonObject.get("model").getAsString();

            if (vehicleType.equals("car")) {
                String carTypeString = jsonObject.get("carType").getAsString();
                CarType carType = CarType.typeMap.get(carTypeString);
                int topSpeed = jsonObject.get("topSpeed").getAsInt();
                vehicle = new Car(engine, model, powerHp, carType, topSpeed, registrationNumber);
            }

            if (vehicleType.equals("railed")) {
                int railSizeMM = jsonObject.get("railSize").getAsInt();
                String railedVehicleTypeString = jsonObject.get("railedVehicleType").getAsString();
                RailedVehicleType railedVehicleType = RailedVehicleType.typeMap.get(railedVehicleTypeString);
                vehicle = new RailedVehicle(engine, model, powerHp, railedVehicleType, railSizeMM, registrationNumber);
            }

            if (vehicleType.equals("plane")) {
                int numberOfEngines = jsonObject.get("numberOfEngines").getAsInt();
                String planeTypeString = jsonObject.get("planeType").getAsString();
                PlaneType planeType = PlaneType.typeMap.get(planeTypeString);
                vehicle = new Plane(engine, model, powerHp, planeType, numberOfEngines, registrationNumber);
            }

            if (vehicleType.equals("ship")) {
                int cargoVolume = jsonObject.get("cargoVolume").getAsInt();
                ShipType type = ShipType.typeMap.get(jsonObject.get("shipType").getAsString());
                vehicle = new Ship(engine, model, powerHp, type, cargoVolume, registrationNumber);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not read from file!");
        }
        return vehicle;
    }
}
