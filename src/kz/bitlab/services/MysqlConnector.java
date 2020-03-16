package kz.bitlab.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {

    private static Connection connection;

    static {
        connect();
    }

    public static Connection getConnect() {

        return connection;
    }

    private static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationSystemDB?serverTimezone=UTC", "root", "password");
            System.out.println("Connected to the MySQL server successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
