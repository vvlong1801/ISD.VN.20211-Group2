package ecobikerental.capstone_project.entity.db;

import java.sql.*;

/**
 * This class controls the process of connecting to Database
 */
public class EcobikeRentalDB {
    /**
     * Represent for connect
     */
    private static Connection connect;

    /**
     * This method gets connection to Database
     * @return
     */
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

    /**
     * Process the connection
     * @param args - the arguments
     */
    public static void main(String[] args) {
        EcobikeRentalDB.getConnection();
    }
}
