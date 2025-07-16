<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request List</title>

    <!-- Icons & Fonts -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="stylesheet" href="CSS/Display.css">


</head>
<body>

<jsp:include page="View/Header.jsp" />

<div class="hero-section">
    <h1>All Payment Requests</h1>
    <p>Review, update or delete submitted requests below</p>
</div>


<div class="container">
 <button class="assign-task-btn" onclick="window.location.href='insert.jsp'">
        <i class="fas fa-plus"></i> Requests Salary Advance
    </button>
    <div class="search-container">
 
            <input type="text" id="searchID" placeholder="Search">
            <button class="search-btn" onclick="searchTable()">
                <i class="fas fa-search"></i>
            </button>
        </div>
    <table class="task-table">
        <tr>
            <th>ID</th> 
            <th>Name</th> 
            <th>Amount</th> 
            <th>Reason</th> 
            <th>Date</th> 
            <th>Action</th> 
        </tr>

        <c:forEach var="request" items="${allRequest}">
            <tr>
                <td>${request.id}</td>
                <td>${request.name}</td>
                <td>${request.amount}</td>
                <td>${request.reson}</td>
                <td>${request.date}</td>
                <td>
                    <a href="Update.jsp?id=${request.id}&name=${request.name}&amount=${request.amount}&reson=${request.reson}&date=${request.date}">
                        <button class="action-btn update-btn">Update</button>
                    </a>
                    <form action="DeleteServlet" method="post" onsubmit="return confirm('Are you sure you want to delete this record?');">
                        <input type="hidden" name="id" value="${request.id}" />
                        <button type="submit" class="action-btn delete-btn">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="View/Footer.jsp" />
 <script>  //Search bar
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

</body>
</html>
