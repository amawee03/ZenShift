package com.oop.staffManagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.oop.staffManagement.util.DBTaskCon;
import com.oop.staffManagement.model.TaskModel;

public class TaskController {

    public static boolean insertData(String employeeID, String employeeName, String taskName, String taskDescription, LocalDate dueDate, String priority) {
  
    	boolean isSuccess = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBTaskCon.getConnection();

            String sql = "INSERT INTO tasks (employee_ID, employee_Name, task_Name, task_Description, dueDate, priority) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employeeID);
            pstmt.setString(2, employeeName);
            pstmt.setString(3, taskName);
            pstmt.setString(4, taskDescription);

            LocalDateTime dueDateTime = dueDate != null ? dueDate.atStartOfDay() : null;
            pstmt.setDate(5, dueDate != null ? java.sql.Date.valueOf(dueDate) : null);


            pstmt.setString(6, priority);

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;
            //System.out.println("Rows affected: " + rowsAffected);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Insert failed due to: " + e.getMessage());
        } finally {
            try { 
            	pstmt.close(); 
            	con.close(); 
            	} catch (Exception e) {
            		e.printStackTrace(); 
            		}
        }

        return isSuccess;
    }

    public static List<TaskModel> getById(String taskId) {
        List<TaskModel> tasks = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;

        try {
            int convertedID = Integer.parseInt(taskId);
            con = DBTaskCon.getConnection();

            String sql = "SELECT * FROM tasks WHERE task_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, convertedID);
            rst = pstmt.executeQuery();

            while (rst.next()) {
                TaskModel task = extractTaskFromResultSet(rst);
                tasks.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { 
            	rst.close();
            	pstmt.close();
            	con.close(); 
            	} catch (Exception e) { 
            		e.printStackTrace(); 
            		}
        }

        return tasks;
    }

    public static List<TaskModel> getAllTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;

        try {
            con = DBTaskCon.getConnection();
            //System.out.println("DB Connection: " + con);
            String sql = "SELECT * FROM tasks";
            pstmt = con.prepareStatement(sql);
            rst = pstmt.executeQuery();

            while (rst.next()) {
            	
                TaskModel task = extractTaskFromResultSet(rst);
                tasks.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try { 
            	  pstmt.close(); 
            	} catch (Exception e) {
            		e.printStackTrace(); }
            
        }

        //System.out.println("Total tasks fetched: " + tasks.size());
        return tasks;
    }

    public static boolean updateData(String taskID, String employeeID, String employeeName, String taskName, String taskDescription, LocalDate dueDate, String priority) {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBTaskCon.getConnection();

            String sql = "UPDATE tasks SET employee_ID = ?, employee_Name = ?, task_Name = ?, task_Description = ?, dueDate = ?, priority = ? WHERE task_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employeeID);
            pstmt.setString(2, employeeName);
            pstmt.setString(3, taskName);
            pstmt.setString(4, taskDescription);

            LocalDateTime dueDateTime = dueDate != null ? dueDate.atStartOfDay() : null;
            pstmt.setTimestamp(5, dueDateTime != null ? Timestamp.valueOf(dueDateTime) : null);

            pstmt.setString(6, priority);
            pstmt.setInt(7, Integer.parseInt(taskID));

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { 
            	pstmt.close(); 
            } catch (Exception e) { 
            		e.printStackTrace(); 
            		}
        }

        return isSuccess;
    }

    private static TaskModel extractTaskFromResultSet(ResultSet rst) throws Exception {
        int taskID = rst.getInt("task_id");
        String employeeID = rst.getString("employee_ID");
        String employeeName = rst.getString("employee_Name");
        String taskName = rst.getString("task_Name");
        String taskDescription = rst.getString("task_Description");

        Timestamp assignedTs = rst.getTimestamp("assigned_Date");
        LocalDateTime assignedDate = assignedTs != null ? assignedTs.toLocalDateTime() : null;

        Timestamp dueTs = rst.getTimestamp("dueDate");
        LocalDate dueDate = dueTs != null ? dueTs.toLocalDateTime().toLocalDate() : null;

        String priority = rst.getString("priority");

        return new TaskModel(taskID, employeeID, employeeName, taskName, taskDescription, assignedDate, dueDate, priority);
    }
    
    public static boolean deleteData(int taskID) {
        boolean isSuccess = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBTaskCon.getConnection();
            stmt = conn.prepareStatement("DELETE FROM tasks WHERE task_id = ?");
            stmt.setInt(1, taskID);

            int rowsAffected = stmt.executeUpdate();
            isSuccess = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

        return isSuccess;
    }


}
