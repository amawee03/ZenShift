<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Home | ZenShift</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
      <link rel="stylesheet" href="CSS/welcome.css">
    <link rel="stylesheet" href="CSS/style.css">
    
</head>
<body>
 <jsp:include page="View/Header.jsp" />
 
 
    <div class="welcome-container">
        <div class="profile-card">
            <div class="profile-header">
                <div class="profile-avatar">
                    <i class="fas fa-user"></i>
                </div>
                <h2 class="welcome-message">Welcome, ${sessionScope.userName}!</h2>
            </div>
            
            <div class="row">
                <div class="col-md-6 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><i class="fas fa-user"></i> Profile Information</h5>
                            <ul class="list-unstyled">
                                <li><strong>Name:</strong> ${sessionScope.userName}</li>
                                <li><strong>Email:</strong> ${sessionScope.userEmail}</li>
                                <li><strong>Role:</strong> ${sessionScope.userRole}</li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="col-md-6 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><i class="fas fa-cog"></i> Quick Actions</h5>
                            <div class="d-grid gap-2">
                                <a href="profile.jsp" class="btn btn-outline-primary">
                                    <i class="fas fa-user-edit"></i> Edit Profile
                                </a>
                                <a href="LogoutServlet" class="btn btn-outline-danger">
                                    <i class="fas fa-sign-out-alt"></i> Logout
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="View/Footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 