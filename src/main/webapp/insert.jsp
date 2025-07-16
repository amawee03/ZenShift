<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZenShift</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
 <link rel="stylesheet" href="CSS/salaryForm.css">
 <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<jsp:include page="View/Header.jsp" />


    <main>
        <section class="pay-form-section">
          <h2>Salary Advance Request</h2>
				
	         <form action="InsertServlet" method="post" class ="pay-form">
            <div class="form-group">
              <label for="employeeName"><i class="fas fa-user"></i> Employee Name</label>
              <input type="text" id="employeeName" name="name" required placeholder="Enter your name">
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
              <label for="repaymentDate"><i class="fas fa-calendar-alt"></i> Proposed Re-Payment Date</label>
              <input type="date" id="repaymentDate" name="date" required>
                <script>
				  document.getElementById('repaymentDate').min = new Date().toISOString().split('T')[0];
				</script>
            </div>
            <button type="submit" class="submit-btn"><i class="fas fa-paper-plane"></i> Submit Request</button>
          </form>
          
                </section>
      </main>
<jsp:include page="View/Footer.jsp" />
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>