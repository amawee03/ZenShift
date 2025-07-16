package com.oop.staffManagement.controller;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.staffManagement.util.DBTaskCon;
import com.oop.staffManagement.model.RequestModel;

public class Requestcontrole {

	private static boolean isSuccess;
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	
	//insert data function
	public static boolean insertdata(String name,String amount,String reson,String date ) {
		boolean isSuccess=false;
		try {
			con=DBTaskCon.getConnection(); //abstraction is used here
			stmt=con.createStatement();
			
			String sql="insert into requestsalery values(0,'"+name+"','"+amount+"','"+reson+"','"+date+"')";
			int rs=stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess =true;
			}
			else {
				isSuccess=false;

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	public static List<RequestModel>getBYId(String Id){
		int convertedID=Integer.parseInt(Id);
		
		ArrayList<RequestModel>request=new ArrayList<>();
		
		try {
			con=DBTaskCon.getConnection();
			stmt=con.createStatement();
			
			String sql="select *from requestsalery where id '"+convertedID+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String amount=rs.getString(3);
				String reson=rs.getString(4);
				String date=rs.getString(5);
				
				RequestModel rr=new RequestModel(id,name,amount,reson,date);
				request.add(rr);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return request;
		
	}
	public static List<RequestModel>getAllRequest(){
		ArrayList<RequestModel>requests=new ArrayList<>();
		try {
			con=DBTaskCon.getConnection();
			stmt=con.createStatement();
			
			String sql="select *from requestsalery";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String amount=rs.getString(3);
				String reson=rs.getString(4);
				String date=rs.getString(5);
				
				RequestModel rr=new RequestModel(id,name,amount,reson,date);
				requests.add(rr);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requests;
	}
	
	public static boolean updatedata(String id,String name,String amount,String reson,String date) {
		try {
			con=DBTaskCon.getConnection();
			stmt=con.createStatement();
			
			String sql="update requestsalery set name='"+name+"',amount='"+amount+"',reson='"+reson+"',date='"+date+"'"
					+"where id='"+id+"'";
			int rs=stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess =true;
			}
			else {
				isSuccess=false;

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
			
	}
	//Delete data
	public static boolean deletedata(String id) {
		int convID=Integer.parseInt(id);
		try {
			con=DBTaskCon.getConnection();
			stmt=con.createStatement();
			String sql="delete from requestsalery where id='"+convID+"'";
			int rs=stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess =true;
			}
			else {
				isSuccess=false;

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
}