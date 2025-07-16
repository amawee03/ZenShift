<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | ZenShift</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="stylesheet" href="CSS/taskForm.css">
</head>
<body>
	
	<%
	String leaveID = request.getParameter("leaveID");
	String empID = request.getParameter("empID");
	String leaveType = request.getParameter("leaveType");
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	String reason = request.getParameter("reason");
	%>

<jsp:include page="View/Header.jsp" />

<div class="assign-task-section">
    <h2>Update Leave Request</h2>
    
    <form action="reqUpdateServlet" method="post" class="assign-task-form">
        <div class="task-form-group">
            <label for="leaveid">Leave ID:</label>
            <input type="text" id="leaveid" name="leaveID" value="<%=leaveID%>" readonly>
        </div>

        <div class="task-form-group">
            <label for="empID">Employee ID:</label>
            <input type="text" id="empID" name="empID" value="<%=empID%>" required>
        </div>

        <div class="task-form-group">
            <label for="type">Leave Type:</label>
            <select id="type" name="leaveType" required>
                <option value="">Select Leave Type</option>
                <option value="annual" <%= "annual".equals(leaveType) ? "selected" : "" %>>Annual</option>
                <option value="sick" <%= "sick".equals(leaveType) ? "selected" : "" %>>Sick</option>
                <option value="casual" <%= "casual".equals(leaveType) ? "selected" : "" %>>Casual</option>
                <option value="maternity" <%= "maternity".equals(leaveType) ? "selected" : "" %>>Maternity</option>
                <option value="unpaid" <%= "unpaid".equals(leaveType) ? "selected" : "" %>>Unpaid</option>
            </select>
        </div>

        <div class="task-form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" value="<%=startDate%>" required>
        </div>

        <div class="task-form-group">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" value="<%=endDate%>" required>
        </div>

        <div class="task-form-group">
            <label for="reason">Reason:</label>
            <input type="text" id="reason" name="reason" value="<%=reason%>" required>
        </div>

        <button type="submit" class="task-submit-btn"><i class="fas fa-paper-plane"></i> Submit</button>
    </form>
</div>

<jsp:include page="View/Footer.jsp" />
</body>
</html>