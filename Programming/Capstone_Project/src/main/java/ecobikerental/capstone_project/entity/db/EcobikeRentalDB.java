package ecobikerental.capstone_project.entity.db;

import java.sql.*;

public class EcobikeRentalDB {
    private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) {
            return connect;
        }
        try {
            String url = "jdbc:mysql://localhost:3306/ecobikerental";
            connect = DriverManager.getConnection(url, "root", "12345");
            System.out.println("connected");
            return connect;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        EcobikeRentalDB.getConnection();
    }
}
