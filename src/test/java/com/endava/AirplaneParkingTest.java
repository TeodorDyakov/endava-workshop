package com.endava;

import com.endava.domainModel.Car;
import com.endava.domainModel.RailedVehicle;
import com.endava.domainModel.Vehicle;
import com.endava.io.VehicleJSONreader;
import com.endava.parking.AirplaneParking;
import org.junit.Before;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AirplaneParkingTest {

    static VehicleJSONreader vehicleJSONreader;
    static Vehicle vehicle1;
    static Vehicle vehicle2;
    static Vehicle car;
    static Vehicle metro;
    static final int CAPACITY = 2;
    static final BigDecimal pricePerMinute = new BigDecimal(5);
    static PaymentProcessor paymentProcessor = new PaymentProcessor();
    static AirplaneParking parking;

    static {
        vehicleJSONreader = new VehicleJSONreader();
        vehicle1 = vehicleJSONreader.readVehicleFromFile("plane.json");
        vehicle2 = vehicleJSONreader.readVehicleFromFile("ship.json");
        car = (Car) vehicleJSONreader.readVehicleFromFile("car.json");
        metro = (RailedVehicle) vehicleJSONreader.readVehicleFromFile("metro.json");
    }

    @Before
    public void init() {
        parking = new AirplaneParking(CAPACITY, paymentProcessor, pricePerMinute);
    }

    @org.junit.Test
    public void enterVehicle() {
        boolean entered = parking.enterVehicle(car);
        boolean enteredVehicle1 = parking.enterVehicle(vehicle1);
        boolean enteredVehicle2 = parking.enterVehicle(vehicle2);
        assertEquals(entered, true);
        assertEquals(enteredVehicle1, true);
        assertEquals(enteredVehicle2, false);
    }

    @org.junit.Test
    public void exitVehicle() {
        parking.enterVehicle(vehicle2);
        boolean exited = parking.exitVehicle(vehicle2);
        assertEquals(true, exited);
    }

    @org.junit.Test
    public void getNumberOfFreeSpots() {
        parking.enterVehicle(car);
        parking.enterVehicle(vehicle1);
        assertEquals(0, parking.getNumberOfFreeSpots());
    }
}