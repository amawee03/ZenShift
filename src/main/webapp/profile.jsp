<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
      <link rel="stylesheet" href="CSS/profile.css">
  
</head>
<body>
   <div class="profile-container">
        <div class="profile-card">
            <h2 class="form-title text-center">Edit Profile</h2>
            
            <form action="UpdateProfileServlet" method="post" class="needs-validation" novalidate>
                <div class="mb-3">
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name" 
                           value="${sessionScope.userName}" required>
                    <div class="invalid-feedback">
                        Please enter your name.
                    </div>
                </div>
                
                <div class="mb-3">
                    <label for="email" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" 
                           value="${sessionScope.userEmail}" required>
                    <div class="form-text">Email cannot be changed.</div>
                </div>
                
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" id="phone" name="phone" 
                           value="${sessionScope.userPhone}" pattern="[0-9]{10}" required>
                    <div class="invalid-feedback">
                        Please enter a valid 10-digit phone number.
                    </div>
                </div>
                
                <div class="mb-3">
                    <label for="currentPassword" class="form-label">Current Password</label>
                    <input type="password" class="form-control" id="currentPassword" 
                           name="currentPassword" required>
                    <div class="invalid-feedback">
                        Please enter your current password.
                    </div>
                </div>
                
                <div class="mb-3">
                    <label for="newPassword" class="form-label">New Password (leave blank to keep current)</label>
                    <input type="password" class="form-control" id="newPassword" 
                           name="newPassword" minlength="6">
                    <div class="invalid-feedback">
                        Password must be at least 6 characters long.
                    </div>
                </div>
                
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary">
                        <i class="fas fa-save"></i> Update Profile
                    </button>
                    <a href="welcome.jsp" class="btn btn-secondary">
                        <i class="fas fa-times"></i> Cancel
                    </a>
                </div>
            </form>
        </div>
    </div>

  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Form validation
        (function () {
            'use strict'
            var forms = document.querySelectorAll('.needs-validation')
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }
                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
</body>
</html> 