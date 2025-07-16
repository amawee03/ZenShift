package com.oop.staffManagement.controller;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.staffManagement.util.DBTaskCon;
import com.oop.staffManagement.model.RequestLevModel;

public class ReqLeaveController {
//Navod	
	//Connect DB
    private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	
	//Insert Data function
		public static boolean insertdata (String empID, String leaveType, String startDate, String endDate, String reason) {
			
			boolean isSuccess = false;
		
		try {
			//DB connection call
			con=DBTaskCon.getConnection(); //abstraction is used here
			stmt=con.createStatement();
			
			//SQL query
			String sql = "INSERT INTO request_leave VALUES(0, '"+empID+"', '"+leaveType+"', '"+startDate+"', '"+endDate+"', '"+reason+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
		
		
		//GetByID
		public static List <RequestLevModel> getById (String LeaveID){
			
			int convertedID = Integer.parseInt(LeaveID);
			
			ArrayList <RequestLevModel> leave = new ArrayList<>();
			
			try { 
				//DBConnection
				con=DBTaskCon.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "SELECT * FROM request_leave WHERE leaveID= " + convertedID;

				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					
					int leaveID = rs.getInt(1);
					String empID = rs.getString(2);
					String leaveType = rs.getString(3);
					String startDate = rs.getString(4);
					String endDate = rs.getString(5);
					String reason = rs.getString(6);
					
					
					RequestLevModel rm = new RequestLevModel(leaveID, empID, leaveType, startDate, endDate, reason);
					leave.add(rm);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return leave;
		}
		
		
		
		//GetAll Data
		
		public static List<RequestLevModel> getAllRequest (){
			ArrayList <RequestLevModel> leaves = new ArrayList<>();
			
			try { 
				//DBConnection
				con=DBTaskCon.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "SELECT * FROM request_leave ";
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int leaveID = rs.getInt(1);
					String empID = rs.getString(2);
					String leaveType = rs.getString(3);
					String startDate = rs.getString(4);
					String endDate = rs.getString(5);
					String reason = rs.getString(6);
					
					RequestLevModel rm = new RequestLevModel(leaveID, empID, leaveType, startDate, endDate, reason);
					leaves.add(rm);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return leaves;
		}
		
		
		
		//UPDATE Controller
		public static boolean updatedata(String leaveID, String empID, String leaveType, String startDate, String endDate, String reason) {
			try {
				//DBConnection
				con=DBTaskCon.getConnection();
				stmt=con.createStatement();
				
				//SQL query
				String sql = "UPDATE request_leave SET empID='"+empID+"', leaveType='"+leaveType+"', startDate='"+startDate+"', endDate='"+endDate+"', reason='"+reason+"' "
				           + "WHERE leaveID=" + leaveID;

				
				int rs = stmt.executeUpdate(sql);
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		
		

		//Delete data
		
		public static boolean deletedata(String leaveID) {
			int convID = Integer.parseInt(leaveID);
			try {
				//DBConnection
				con=DBTaskCon.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "DELETE FROM request_leave WHERE leaveID='"+convID+"'";
						
				
				int rs = stmt.executeUpdate(sql);
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
			
		
		
		
		
		
		
}