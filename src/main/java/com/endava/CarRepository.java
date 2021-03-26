package com.endava;

import com.endava.domainModel.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarRepository {

    public boolean saveCar(Car car) {
        final String preparedStatement =
            ("INSERT INTO `cars` (`type`, `model`, `engine`, `powerHP`, `topSpeed`, `regitstrationNumber`) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')")
                .formatted(car.getType(), car.getModel(), car.getEngine(), car.getPowerHP(), car.getTopSpeed(),
                    car.getRegistrationNumber());

        System.out.println(preparedStatement);
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vehicle", "root", "");

            PreparedStatement stmt = con.prepareStatement(preparedStatement);
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
