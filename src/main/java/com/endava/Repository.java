package com.endava;

import com.endava.domainModel.Car;
import com.endava.domainModel.Ship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Repository {

    public boolean saveCar(Car car) {
        final String preparedStatement =
            ("INSERT INTO `cars` (`type`, `model`, `engine`, `powerHP`, `topSpeed`, `registrationNumber`) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')")
                .formatted(car.getType(), car.getModel(), car.getEngine(), car.getPowerHP(), car.getTopSpeed(),
                    car.getRegistrationNumber());

        return executeUpdate(preparedStatement);
    }

    public boolean saveShip(Ship ship) {
        final String preparedStatement =
            ("INSERT INTO `ships` (`type`, `model`, `engine`, `powerHP`, `cargoVolume`, `registrationNumber`) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')")
                .formatted(ship.getType(), ship.getModel(), ship.getEngine(), ship.getPowerHP(), ship.getCargoVolume(),
                    ship.getRegistrationNumber());

        return executeUpdate(preparedStatement);
    }

    private boolean executeUpdate(String preparedStatement) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vehicle", "root", "");

            PreparedStatement stmt = con.prepareStatement(preparedStatement);
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
