<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | ZenShift</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/taskForm.css">

</head>
<body>
<%
		 String taskID = request.getParameter("taskID");
		 String employeeID=request.getParameter("employeeID");
		 String employeeName=request.getParameter("employeeName");
		 String taskName=request.getParameter("taskName");
		 String taskDescription=request.getParameter("taskDescription");
		 String assignedDate=request.getParameter("assignedDate");
		 String dueDate=request.getParameter("dueDate");
		 String priority=request.getParameter("priority");
		 
	        LocalDate dueDateObj = null;
	        if (dueDate != null && !dueDate.trim().isEmpty()) {
	            dueDateObj = LocalDate.parse(dueDate);
	        }
%>
 <jsp:include page="View/Header.jsp" />
    <main>
    
        <section class="assign-task-section">
            <h2>Assign Task to Employee</h2>
            <form name="taskForm" action="UpdateTaskServlet" onsubmit="return validateTaskForm()" method="post" class="assign-task-form">

			<div class="task-form-group">
                <label for="taskID"><i class="fas fa-user"></i> Task ID</label>
                <input type="text" id="taskID" name="taskID" readonly 
                       value="<%=taskID%>" />
                      
            </div>
            <div class="task-form-group">
                <label for="employeeName"><i class="fas fa-user"></i> Employee Name</label>
                <input type="text" id="employeeName" name="employeeName" required 
                       value="<%=employeeName%>" />
            </div>
            <div class="task-form-group">
                <label for="employeeId"><i class="fas fa-id-badge"></i> Employee ID</label>
                <input type="text" id="employeeId" name="employeeID" required 
                       value="<%= employeeID%>" />
            </div>
            <div class="task-form-group">
                <label for="taskTitle"><i class="fas fa-tasks"></i> Task Title</label>
                <input type="text" id="taskTitle" name="taskName" required placeholder="Enter task title"
                       value="<%= taskName %>" />
            </div>
            <div class="task-form-group">
                <label for="taskDescription"><i class="fas fa-align-left"></i> Task Description</label>
                <textarea id="taskDescription" name="taskDescription" rows="3" required placeholder="Describe the task"><%= taskDescription%></textarea>
            </div>
            
            <div class="task-form-group">
                <label for="dueDate"><i class="fas fa-calendar-day"></i> Due Date</label>
                <input type="date" id="dueDate" name="dueDate" required
                       value="<%=dueDate%>" />
            </div>
            <div class="task-form-group">
                <label for="priority"><i class="fas fa-exclamation-circle"></i> Priority</label>
                <select id="priority" name="priority" required>
                    <option value="">Select priority</option>
                    <option value="low" <%= "low".equals(priority) ? "selected" : "" %>>Low</option>
                    <option value="medium" <%= "medium".equals(priority) ? "selected" : "" %>>Medium</option>
                    <option value="high" <%= "high".equals(priority) ? "selected" : "" %>>High</option>
                </select>
            </div>
            <button type="submit" class="task-submit-btn"><i class="fas fa-paper-plane"></i> Update Task</button>
        </form>
          </section>
           
    </main>
    
    
    
    
    <!-- Footer -->
     <jsp:include page="View/Footer.jsp" />

<script>
function validateTaskForm() {
    var employeeID = document.forms["taskForm"]["employeeID"].value.trim();
    var taskName = document.forms["taskForm"]["taskName"].value.trim();
    var dueDate = document.forms["taskForm"]["dueDate"].value;
    var priority = document.forms["taskForm"]["priority"].value;

    // Check empty fields
    if (employeeID == "") {
        alert("Employee ID is required.");
        return false;
    }

    if (taskName == "") {
        alert("Task Name is required.");
        return false;
    }

    if (dueDate == "") {
        alert("Due Date is required.");
        return false;
    }

    if (priority == "") {
        alert("Priority is required.");
        return false;
    }

    // Validate future date
    var selectedDate = new Date(dueDate);
    var today = new Date();
    today.setHours(0, 0, 0, 0);

    if (selectedDate < today) {
        alert("Due Date cannot be in the past.");
        return false;
    }

    return true;
}
}
</script>
   
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

</body>
</html>