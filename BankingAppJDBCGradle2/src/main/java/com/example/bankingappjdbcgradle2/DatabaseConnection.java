package com.example.bankingappjdbcgradle2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //VM
//    private static final String URL = "jdbc:mysql://VM_IP_Address:3306/sesi12";
//    private static final String USER = "user_bank";
//    private static final String PASSWORD = "password123";

    //local
    private static final String URL = "jdbc:mysql://localhost:3306/fintech_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return connection;
    }
}
