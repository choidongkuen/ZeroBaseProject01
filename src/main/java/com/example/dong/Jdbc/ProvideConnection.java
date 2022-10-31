package com.example.dong.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProvideConnection {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mariadb://localhost:3306/assign01";
        String dbUserId = "choidongkuen";
        String password = "ehdrms6390";

        return DriverManager.getConnection(url,dbUserId,password);
    }
}
