package ru.project.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

public class Repository {
    private Connection connection;
    private Statement stmt;
    private final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=cardb";


    public Repository(){
        try {
            connect();
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect");
        }
    }

    Statement getStmt() {
        return stmt;
    }

    Connection getConnection() {
        return connection;
    }

    void connect() throws SQLException {
        HashMap<String, String> login = GetUserPassword.readLoginDB();
        Properties properties = new Properties();
        properties.setProperty("user", login.get("user"));
        properties.setProperty("password", login.get("password"));
        connection = DriverManager.getConnection(url, properties);
        stmt = connection.createStatement();
    }

    void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
