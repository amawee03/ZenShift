package com.oop.staffManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTaskCon {

	
	private static String url = "jdbc:mysql://localhost:3306/staffmanagement";
    private static String user = "root";
    private static String password = "ama123"; // Update with your database password
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return con;
    }
}
