<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    // Session-based security: only allow logged-in non-admin users
    String userRole = (String) session.getAttribute("userRole");
    String userName = (String) session.getAttribute("user");

    if (userName == null || "admin".equals(userRole)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="CSS/style.css">
   <link rel="stylesheet" href="CSS/userDashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

</head>
<body>
 <div class="container-fluid px-0">
    <jsp:include page="View/Header.jsp" />
</div>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
           <div class="col-md-3 col-lg-2 sidebar">
                <h3 class="text-white text-center mb-4">Staff Panel</h3>
                <a href="userDashboard.jsp" class="active mb-2">
                    <i class="fas fa-user"></i> My Dashboard
                </a>
                <a href="welcome.jsp" class="mb-2">
                    <i class="fas fa-user-circle"></i> My Profile
                </a>
                <a href="tasks.jsp" class="mb-2">
                    <i class="fas fa-tasks"></i> My Tasks
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
                                    <a href="InsertTask.jsp" class="btn btn-info">
                                        <i class="fas fa-file-export"></i> Assign Task
                                    </a>
                                    <a href="#" class="btn btn-warning">
                                        <i class="fas fa-cog"></i> My leaves
                                    </a>
                                    <a href="#" class="btn btn-warning">
                                        <i class="fas fa-cog"></i> Settings
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
