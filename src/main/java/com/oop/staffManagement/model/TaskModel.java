package com.oop.staffManagement.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskModel {
	/* Data encapsulation is here as all the attributes 
		are private
	*/
	private int taskID;
    private String employeeID;
    private String employeeName;
    private String taskName;
    private String taskDescription;
    private LocalDateTime assignedDate; 
    private LocalDate dueDate;          
    private String priority;
    
	public TaskModel(int taskID, String employeeID, String employeeName, String taskName, String taskDescription,
			LocalDateTime assignedDate, LocalDate dueDate, String priority) {
		super();
		this.taskID = taskID;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.priority = priority;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssignedDateString() {
	    return assignedDate != null ? assignedDate.toString() : "";
	}

	public String getDueDateString() {
	    return dueDate != null ? dueDate.toString() : "";
	}


	
    
	
}
