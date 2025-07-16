<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
	if (session == null || session.getAttribute("user") == null || 
	!"admin".equals(session.getAttribute("userRole"))) {
	response.sendRedirect("login.jsp");
	return;
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="CSS/style.css">
 	<link rel="stylesheet" href="CSS/adminDashboard.css">
  
</head>
<body>
 <jsp:include page="View/Header.jsp" />
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-3 col-lg-2 sidebar">
                <h3 class="text-white text-center mb-4">Admin Panel</h3>
                <a href="adminDashboard.jsp" class="active mb-2">
                    <i class="fas fa-tachometer-alt"></i> Dashboard
                </a>
                <a href="UsersListServlet" class="mb-2">
                    <i class="fas fa-users"></i> Manage Staff
                </a>
                <a href="LogoutServlet" class="mt-5">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </a>
            </div>

            <!-- Main Content -->
            <div class="col-md-9 col-lg-10 content">
                <h2 class="mb-4">Welcome, ${sessionScope.user}!</h2>

                <div class="row">
                    <!-- Quick Actions -->
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title mb-0">Quick Actions</h5>
                            </div>
                            <div class="card-body">
                                <div class="quick-actions">
                                    <a href="UsersListServlet" class="btn btn-primary">
                                        <i class="fas fa-users"></i> Manage Staff Members
                                    </a>
                                    <a href="Tasks.jsp" class="btn btn-info">
                                        <i class="fas fa-file-export"></i> Assign Task
                                    </a>
                                    <a href="#" class="btn btn-warning">
                                        <i class="fas fa-cog"></i> Settings
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

 <jsp:include page="View/Footer.jsp" />
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
