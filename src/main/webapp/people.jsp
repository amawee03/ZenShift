<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oop.staffManagement.model.UserModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oop.staffManagement.controller.StaffUserController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<UserModel> staffList = StaffUserController.getAllStaff();
    request.setAttribute("allStaffs", staffList);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>People - Staff Directory</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap @5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css ">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
      <link rel="stylesheet" href="CSS/people.css">
    
 
</head>
<body>

<!-- Header Include -->
<jsp:include page="View/Header.jsp" />

<!-- Hero Section -->
<div class="hero-section">
    <h1>Staff Directory</h1>
    <p>View all registered employees in the system</p>
</div>
<br><br><br>
 <div class="search-container">
 
            <input type="text" id="searchID" placeholder="Search">
            <button class="search-btn" onclick="searchTable()">
                <i class="fas fa-search"></i>
            </button>
        </div>

<!-- Users Table -->
<div class="table-container">
    <table class="task-table" id="staffTable">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Role</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${allStaffs}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.role}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Footer Include -->
<jsp:include page="View/Footer.jsp" />

<!-- JavaScript for Search Functionality -->
<script>
    function filterTable() {
        const input = document.getElementById("searchInput");
        const filter = input.value.toLowerCase();
        const table = document.getElementById("staffTable");
        const tr = table.getElementsByTagName("tr");

        for (let i = 1; i < tr.length; i++) {
            const tdName = tr[i].getElementsByTagName("td")[1];
            const tdEmail = tr[i].getElementsByTagName("td")[2];
            if (tdName || tdEmail) {
                const txtValueName = tdName.textContent || tdName.innerText;
                const txtValueEmail = tdEmail.textContent || tdEmail.innerText;
                if (txtValueName.toLowerCase().indexOf(filter) > -1 ||
                    txtValueEmail.toLowerCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

</body>
</html>