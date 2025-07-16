package com.oop.staffManagement.model;

public class RequestLevModel {
	
	private int leaveID;
	private String empID;
	private String leaveType;
	private String startDate;
	private String endDate;
	private String reason;
	
	
	public RequestLevModel(int leaveID, String empID, String leaveType, String startDate, String endDate, String reason) {
		super();
		this.leaveID = leaveID;
		this.empID = empID;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
	}


	public int getLeaveID() {
		return leaveID;
	}


	public String getEmpID() {
		return empID;
	}


	public String getLeaveType() {
		return leaveType;
	}


	public String getStartDate() {
		return startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public String getReason() {
		return reason;
	}


	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}


	public void setEmpID(String empID) {
		this.empID = empID;
	}


	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
	
}