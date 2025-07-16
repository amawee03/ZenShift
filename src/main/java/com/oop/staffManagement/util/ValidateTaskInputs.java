package com.oop.staffManagement.util;

import java.time.LocalDate;

public class ValidateTaskInputs {

	//Tasks
	//To validate employee name
	public static boolean isName(String employeeName) {
        String namePattern = "^[A-Za-z ]*$";
        if (employeeName != null && employeeName.matches(namePattern)) {
            return true;
        } else {
            return false;
        }
    }

	//to validate task description
    public static boolean isValidDescription(String taskDescription) {
        if (taskDescription != null && taskDescription.trim().length() >= 30) {
            return true;
        } else {
            return false;
        }
    }

    //validate due date
    public static boolean isDueDateValid(LocalDate dueDate) {
        LocalDate today = LocalDate.now();
        return !dueDate.isBefore(today);
    }
    
    
    //Salary
   
    public static boolean isValidSalary(String salary) {
        String salaryPattern = "^[0-9]+(\\.[0-9]{1,2})?$";
        return salary != null && salary.matches(salaryPattern);
    }
    
    //Registration Page 
    public static boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailPattern);
    }
    
    public static boolean empId(String empID ) {
    	String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
        return empID.matches(regex);
    }
    
}
