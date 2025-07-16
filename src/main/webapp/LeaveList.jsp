<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Leave Requests</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/Leavelist.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="stylesheet" href="CSS/TaskDisplay.css">
    
</head>
<body>
<jsp:include page="View/Header.jsp" />

<div class="hero-section">
    <h1>All Leave Requests</h1>
    <p></p>
</div>
<div class="container">
    <h2>Employee Leave Requests</h2>
      <button class="assign-task-btn" onclick="window.location.href='reqInsert.jsp'">
        <i class="fas fa-plus"></i> Request Leave
    </button>
    
     <div class="search-container">
 
            <input type="text" id="searchID" placeholder="Search">
            <button class="search-btn" onclick="searchTable()">
                <i class="fas fa-search"></i>
            </button>
        </div>
    <table class="task-table">
        <tr>
            <th>Leave ID</th>
            <th>Employee ID</th>
            <th>Leave Type</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Reason</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="leave" items="${allRequests}">
        <tr>
            <td>${leave.leaveID}</td>
            <td>${leave.empID}</td>
            <td>${leave.leaveType}</td>
            <td>${leave.startDate}</td>
            <td>${leave.endDate}</td>
            <td>${leave.reason}</td>
            <td>
                <a href="reqUpdate.jsp?leaveID=${leave.leaveID}&empID=${leave.empID}&leaveType=${leave.leaveType}&startDate=${leave.startDate}&endDate=${leave.endDate}&reason=${leave.reason}">
                    <button class="action-btn update-btn">Update</button>
                </a>

                <form action="ReqLevDeleteServlet" method="post" style="display:inline;" 
                      onsubmit="return confirm('Are you sure you want to delete this book?');">
                    <input type="hidden" name="leaveID" value="${leave.leaveID}" />
                    <button type="submit" class="action-btn delete-btn">Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
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
