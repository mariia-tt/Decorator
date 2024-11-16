package ua.ucu.edu.apps.decorator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.SneakyThrows;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    @SneakyThrows
    private DBConnection() {        
        this.connection = DriverManager.getConnection(
            "jdbc:sqlite:/Users/mariatsymbal/Desktop/lab10/cache.db");
    }

    @SneakyThrows
    public String getDocument(String gcsPath) {
        PreparedStatement statement 
        = connection.prepareStatement(
            "SELECT * FROM document WHERE path=?");
        statement.setString(1, gcsPath);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.getString("parsed");
    }

    @SneakyThrows
    public void createDocument(String gcsPath, String parsed) {
        PreparedStatement preparedstatement 
            = connection.prepareStatement(
                "INSERT INTO document (path, parsed) VALUES (?, ?)");
        preparedstatement.setString(1, gcsPath);
        preparedstatement.setString(2, parsed);
        preparedstatement.executeUpdate();
        preparedstatement.close();
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public void checkConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Database connection is successful!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
