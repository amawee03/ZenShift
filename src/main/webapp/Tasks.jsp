<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oop.staffManagement.model.TaskModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oop.staffManagement.controller.TaskController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | ZenShift</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="stylesheet" href="CSS/TaskDisplay.css">
</head>

<body>
<%
	List<TaskModel> allTask = TaskController.getAllTasks();
request.setAttribute("allTask", allTask);
%>
<% String message = (String) request.getAttribute("message"); %>
<% String error = (String) request.getAttribute("error"); %>

<script>

<% if (message != null) { %>
    alert('<%= message %>');
<% } else if (error != null) { %>
    alert('<%= error %>');
<% } %>


</script>
     <jsp:include page="View/Header.jsp" />

<!-- Hero Section -->
    <section class="hero-section">
        <h1>Welcome to Task Management</h1>
        <p>Efficiently manage your team's tasks and priorities in one place.</p>
    </section>
    <main class="container">
        

        <!-- Task Table -->
        <c:if test="${not empty successMessage}">
    <div class="alert success">
        ${successMessage}
    </div>
</c:if>

<c:if test="${not empty errorMessage}">
    <div class="alert error">
        ${errorMessage}
    </div>
</c:if>
<h2>Assigned Tasks</h2>
        <button class="assign-task-btn" onclick="window.location.href='InsertTask.jsp'">
        <i class="fas fa-plus"></i> Assign New Task
    </button>
        <div class="search-container">
 
            <input type="text" id="searchID" placeholder="Search">
            <button class="search-btn" onclick="searchTable()">
                <i class="fas fa-search"></i>
            </button>
        </div>
        <table class="task-table">
            <thead>
                <tr>
                
                	<th>Task ID</th>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Task Name</th>
                    <th>Task Description</th>
                    <th>Assigned Date</th>
                    <th>Due Date</th>
                    <th>Priority</th>
                    <th>Actions</th>
                </tr>
                
            </thead>
            
            <tbody>
            <c:forEach var="tasks" items="${allTask}">
                <tr>
                        <td>${tasks.taskID}</td>
                        <td>${tasks.employeeID}</td>
                        <td>${tasks.employeeName}</td>
                        <td>${tasks.taskName}</td>
                        <td>${tasks.taskDescription}</td>
                        <td>${tasks.assignedDateString}</td>
						<td>${tasks.dueDateString}</td>
                        <td>${tasks.priority}</td>
                   
                    <td>
                    <a href = "updateTask.jsp?taskID=${tasks.taskID}&employeeID=${tasks.employeeID}&employeeName=${tasks.employeeName}&taskName=${tasks.taskName}&taskDescription=${tasks.taskDescription}&assignedDate=${tasks.assignedDate}&dueDate=${tasks.dueDate}&priority=${tasks.priority}">
                        <button class="action-btn update-btn">Update</button>
                        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <form action="DeleteTaskServlet" method="POST" style="display:inline;">
    <input type="hidden" name="taskID" value="${tasks.taskID}" />
    <button type="submit" class="action-btn delete-btn" onclick="return confirm('Are you sure you want to delete this task?')">Delete</button>
</form>
                         

                        
                    </td>
                </tr>
                
                </c:forEach>
                
            </tbody>
            
            
        </table>
    </main>
     <jsp:include page="View/Footer.jsp" />


 
 	  <script>
 	 function searchTable(){
 	    var input, filter, table, tr, td, i, textVal, j;
 	    input = document.getElementById("searchID");
 	    filter = input.value.toUpperCase();
 	    table = document.querySelector("table");
 	    tr = table.getElementsByTagName("tr");

 	    for(i = 1; i < tr.length; i++){ // start from 1 to skip the header row
 	        td = tr[i].getElementsByTagName("td");
 	        let rowMatch = false;
 	        for(j = 0; j < td.length; j++){
 	            if(td[j]){
 	                textVal = td[j].textContent || td[j].innerText;
 	                if(textVal.toUpperCase().indexOf(filter) > -1){
 	                    rowMatch = true;
 	                    break;
 	                }
 	            }
 	        }
 	        tr[i].style.display = rowMatch ? "" : "none";
 	    }
 	} 
 	document.getElementById("searchID").addEventListener("input", searchTable);

  
    </script>
    
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

</body>
</html>
