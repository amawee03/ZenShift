package com.oop.staffManagement.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.staffManagement.util.DBTaskCon;
import com.oop.staffManagement.model.UserModel;

public class StaffUserController {
	
	public static boolean insertData(String name, String email, String password, String phone) throws SQLException {
	    boolean isSuccess = false;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        // Get database connection
	        con = DBTaskCon.getConnection(); //abstraction is used here
	        
	        // Create SQL query with all fields including role
	        String sql = "INSERT INTO user (name, email, password, phone, role) VALUES (?, ?, ?, ?, 'user')";
	        pstmt = con.prepareStatement(sql);
	        
	        // Set parameters
	        pstmt.setString(1, name);
	        pstmt.setString(2, email);
	        pstmt.setString(3, password);
	        pstmt.setString(4, phone);
	        
	        // Execute update
	        int affectedRows = pstmt.executeUpdate();
	        isSuccess = affectedRows > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        // Close resources
	        try {
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return isSuccess;
	}
	
	//login validate
	
	public static List<UserModel> loginValidate(String email, String password) throws SQLException {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<UserModel> users = new ArrayList<>();

	    try {
	        // DB Connection
	        con = DBTaskCon.getConnection();

	        // Create SQL query using PreparedStatement
	        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, email);
	        pstmt.setString(2, password);
	        
	        // Execute query
	        rs = pstmt.executeQuery();

	        // Process results
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String userEmail = rs.getString("email");
	            String userPassword = rs.getString("password");
	            String phone = rs.getString("phone");
	            String role = rs.getString("role");

	            // Create and add UserModel
	            UserModel user = new UserModel(id, name, userEmail, userPassword, phone, role);
	            users.add(user);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return users;
	}

    public static List<UserModel> getAllStaff() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<UserModel> staffList = new ArrayList<>();
        
        try {
            con = DBTaskCon.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                UserModel user = new UserModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("role")
                );
                staffList.add(user);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        return staffList;
    }

    public static boolean updateUserProfile(int userId, String name, String email, String phone, String password) throws SQLException {
        String query = "UPDATE user SET name=?, email=?, phone=?, password=? WHERE id=?";
        try (Connection conn = DBTaskCon.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, password);
            pstmt.setInt(5, userId);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public static UserModel getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = DBTaskCon.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new UserModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("role")
                );
            }
            return null;
        }
    }

    public static boolean updateUser(int userId, String name, String email, String phone, String role, String password) throws SQLException {
        String query = "UPDATE user SET name=?, email=?, phone=?, role=?, password=? WHERE id=?";
        try (Connection conn = DBTaskCon.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, role);
            pstmt.setString(5, password);
            pstmt.setInt(6, userId);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public static boolean deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";
        try (Connection conn = DBTaskCon.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, userId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public static boolean insertDataWithRole(String name, String email, String password, String phone, String role) throws SQLException {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            // Get database connection
            con = DBTaskCon.getConnection();
            
            // Create SQL query with all fields including role
            String sql = "INSERT INTO user (name, email, password, phone, role) VALUES (?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            
            // Set parameters
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, phone);
            pstmt.setString(5, role);
            
            // Execute update
            int affectedRows = pstmt.executeUpdate();
            isSuccess = affectedRows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return isSuccess;
    }

}



