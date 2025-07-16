<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="CSS/salaryForm.css">
</head>
<body>
			    <header class="header">
        <div class="logo">
            <i class="fas fa-briefcase"></i> Staff Management
        </div>
        <nav>
            <ul>
                <li><a href="peoples.html">People</a></li>
                <li><a href="">Pay</a></li>
                <li><a href="#">Leaves</a></li>
                <li><a href="#">Tasks</a></li>
                <li><a href="#">Notices</a></li>
            </ul>
        </nav>
        <div class="profile-icon">
            <a href="#">
                <div class="profile-pic">
                    <i class="fas fa-user-circle"></i>
                </div>
            </a>
        </div>
    </header>


    <main>
        <section class="pay-form-section">
          <h2>Salary Advance Request</h2>
				
	         <form action="InsertServlet" method="post">
            <div class="form-group">
              <label for="employeeName"><i class="fas fa-user"></i> Employee Name</label>
              <input type="text" id="employeeName" name="name" required placeholder="Enter your name">
            </div>
            <div class="form-group">
              <label for="employeeId"><i class="fas fa-id-badge"></i> Employee ID</label>
              <input type="text" id="employeeId" name="id" required placeholder="Enter your employee ID">
            </div>
            <div class="form-group">
              <label for="advanceAmount"><i class="fas fa-money-bill-wave"></i> Advance Amount</label>
              <input type="text" id="advanceAmount" name="amount" required min="1" placeholder="Amount requested">
            </div>
            <div class="form-group">
              <label for="reason"><i class="fas fa-comment-dots"></i> Reason for Advance</label>
              <textarea id="reason" name="reson" rows="3" required placeholder="Briefly explain the reason"></textarea>
            </div>
            <div class="form-group">
              <label for="repaymentDate"><i class="fas fa-calendar-alt"></i> Proposed Repayment Date</label>
              <input type="date" id="repaymentDate" name="date" required>
            </div>
            <button type="submit" class="submit-btn"><i class="fas fa-paper-plane"></i> Submit Request</button>
          </form>
          
                  </section>
      </main>

    <footer class="footer">
        <div class="footer-content">
            <p>&copy; 2025 Staff Management. All rights reserved.</p>
            <nav>
                <ul class="footer-nav">
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </div>
    </footer>
</body>
</html>