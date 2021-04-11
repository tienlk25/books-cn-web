package com.example.nhom24.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static Connection connection;
    private DBConfig(){};

    public static boolean hasConnection(){return connection != null;}
    public static Connection getConnection() throws SQLException {
        if(!hasConnection()){
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }

    public static String url = "jdbc:mysql://localhost:3306/db_24";
    public static String username = "root";
    public static String password = "123456";
}
