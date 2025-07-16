<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | ZenShift</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
       
</head>
<body>

</head>
<body>
    <div class="container-fluid px-0">
    <jsp:include page="View/Header.jsp" />
</div>

    <!-- Hero Section -->
    <section class="hero-section">
        <h1>Welcome to ZenShift</h1>
        <p>Your all-in-one staff management system — simplifying tasks, shifts, and performance tracking in one place.</p>
        <a href="Home.jsp" class="cta-btn">Get Started</a>
    </section>

    <!-- About Section -->
    <section class="about-section">
        <h2>About ZenShift</h2>
        <p>ZenShift helps businesses manage employees, tasks, shifts, and payroll efficiently. Our platform integrates everything you need to keep your team organized and productive.</p>
    </section>

    <!-- Features Section -->
    <section class="features-section">
        <h2>Key Features</h2>
        
        <div class="features-grid">
        <a href="people.jsp" style="text-decoration: none; color: inherit;">
            <div class="feature-item">
                <i class="fas fa-user-cog"></i>
                <h3>Employee Management</h3>
                <p>Add, manage, and track employees effortlessly.</p>
            </div>
            </a>
            
            <a href="Tasks.jsp" style="text-decoration: none; color: inherit;">
			    <div class="feature-item">
			        <i class="fas fa-tasks"></i>
			        <h3>Task <br>Assignments</h3>
			        <p>Assign tasks and monitor progress in real time.</p>
			    </div>
			</a>
			
			<a href="Tasks.jsp" style="text-decoration: none; color: inherit;">
            <div class="feature-item">
                <i class="fas fa-calendar-alt"></i>
                <h3>Shift<br> Scheduling</h3>
                <p>Plan and organize shifts for smooth operations.</p>
            </div>
            </a>
            
            <a href="display.jsp" style="text-decoration: none; color: inherit;">
            <div class="feature-item">
                <i class="fas fa-dollar-sign"></i>
                <h3>Payroll<br> Management</h3>
                <p>Manage salaries, advances, and financial records.</p>
            </div>
            </a>
        </div>
    </section>

    <!-- Contact Section -->
    <section class="contact-section">
        <h2>Contact Us</h2>
        <p>Have questions or need support? Reach out to us at <a href="mailto:support@zenshift.com">support@zenshift.com</a> and we’ll be happy to help!</p>
    </section>
    
        <!-- Footer -->
	<jsp:include page="View/Footer.jsp" />
	<!-- Font Awesome (for icons) -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
