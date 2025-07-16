<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home | ZenShift</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }

       .search-container {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 20px;
}

/* Search input field */
.search-container input[type="text"] {
    padding: 10px 15px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-right: none;
    border-radius: 20px 0 0 20px;
    outline: none;
    width: 250px;
    transition: border-color 0.3s;
}

.search-container input[type="text"]:focus {
    border-color: #2C3E50;
}

/* Search button */
.search-btn {
    background-color: #2C3E50; /* blue */
    color: white;
    border: none;
    padding: 10px 15px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 0 20px 20px 0;
    transition: background-color 0.3s;
}

.search-btn:hover {
    background-color: #43666f;
}

.search-btn i {
    pointer-events: none;
}

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
        }

        .task-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 40px;
        }

        .task-table th, .task-table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        .task-table th {
            background-color: #16a085;
            color: #fff;
        }

        .task-table td {
            white-space: nowrap;
        }

        .action-btn {
            padding: 6px 12px;
            margin-right: 5px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .update-btn {
            background-color: #0e6c13;
            color: #fff;
        }

        .delete-btn {
            background-color: #b41818;
            color: #fff;
        }

        .hero-section {
            background: linear-gradient(135deg, #1abc9c, #16a085);
            color: #fff;
            text-align: center;
            padding: 80px 20px;
        }

        .hero-section h1 {
            font-size: 36px;
            margin-bottom: 10px;
        }

        .hero-section p {
            font-size: 18px;
        }
        .assign-task-btn {
    display: inline-block;
    margin-bottom: 15px;
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.3s ease;
}

.assign-task-btn:hover {
    background-color: #45a049;
}
        
    </style>
</head>
<body>
<jsp:include page="View/Header.jsp" />

<div class="hero-section">
    <h1>All Leave Requests</h1>
    <p>Review, update or delete submitted requests below</p>
</div>

    
  
<div class="container">
<h2>Employee Requests</h2>
   <button class="assign-task-btn" onclick="window.location.href='reqInsert.jsp'">
        <i class="fas fa-plus"></i> Assign New Task       
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
    
    <script>  //Search bar JS
    function searchTable(){
      var input, filter, table, tr, td, i, textVal, j;
      input = document.getElementById("searchID");
      filter = input.value.toUpperCase();
      table = document.querySelector("table");
      tr = table.getElementsByTagName("tr");

      for(i = 1; i < tr.length; i++){ 
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
    
    
</div>
<jsp:include page="View/Footer.jsp" />
</body>
</html>