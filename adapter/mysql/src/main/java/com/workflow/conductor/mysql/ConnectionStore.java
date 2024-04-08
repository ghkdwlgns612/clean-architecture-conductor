package com.workflow.conductor.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionStore {

    private static final String URI = "jdbc:mysql://localhost:3306/ndap_workflow";
    private static final String USER = "ndap";
    private static final String PASSWORD = "nexr1234~";

    private ConnectionStore() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URI + "?user=" + USER + "&password=" + PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
