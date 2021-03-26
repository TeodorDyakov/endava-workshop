package com.endava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    public static final String DB_HOSTNAME = "127.0.0.1";
    public static final String DB_PORT = "3306";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";
    private static DbConnector instance;
    private Connection connection;

    public DbConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOSTNAME + ":" + DB_PORT + "/user",
                DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to use MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error communicating with MySQL database. " + e.getMessage());
        }
    }

    public static DbConnector getInstance() {
        if (instance == null) {
            instance = new DbConnector();
        }
        return instance;
    }
}