<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Request Leave</title>
    <link rel="stylesheet" href="CSS/leaveForm.css"> 
    <link rel="stylesheet" href="CSS/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+Georgian&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="View/Header.jsp" />
    <div class="pay-form-section">
        <h2>Request for a Leave</h2>
        <form action="ReqLeaveServlet" method="post" class="pay-form">
            <div class="form-group">
                <label for="id">Employee ID:</label>
                <input type="text" id="id" name="empID" required>
            </div>

            <div class="form-group">
                <label for="type">Leave Type:</label>
                <select id="type" name="leaveType" required>
                    <option value="">Select Leave Type</option>
                    <option value="annual">Annual</option>
                    <option value="sick">Sick</option>
                    <option value="casual">Casual</option>
                    <option value="maternity">Maternity</option>
                    <option value="unpaid">Unpaid</option>
                </select>
            </div>

            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" required>
                  <script>
				  document.getElementById('startDate').min = new Date().toISOString().split('T')[0];
				</script>
            </div>

            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" required>
            <script>
				  document.getElementById('endDate').min = new Date().toISOString().split('T')[0];
				</script>
            </div>

            <div class="form-group">
                <label for="reason">Reason:</label>
                <input type="text" id="reason" name="reason" required>
            </div>

            <button type="submit" class="submit-btn">Submit</button>
        </form>
    </div>
<jsp:include page="View/Footer.jsp" />
</body>
</html>
