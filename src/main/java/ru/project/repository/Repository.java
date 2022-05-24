package ru.project.repository;

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

    private Properties setProperties(){
        HashMap<String, String> login = GetUserPassword.readLoginDB();
        Properties properties = new Properties();
        properties.setProperty("user", login.get("user"));
        properties.setProperty("password", login.get("password"));
        return properties;
    }

    void connect() throws SQLException {
        Properties properties = setProperties();
        connection = DriverManager.getConnection(url, properties);
        stmt = connection.createStatement();
    }

    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throw new RuntimeException("failed to connect", throwables);
        }
    }

    public void commit(){
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throw new RuntimeException("failed to commit", throwables);
        }
    }

    public void setAutoCommit(boolean autoCommit){
        try {
            connection.setAutoCommit(autoCommit);
        } catch (SQLException throwables) {
            throw new RuntimeException("failed to AutoCommit", throwables);
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("failed to disconnect", e);
        }
    }

}
