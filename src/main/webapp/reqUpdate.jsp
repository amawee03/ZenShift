<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ZenShift</title>
 <link rel="stylesheet" href="CSS/taskForm.css">
 <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<jsp:include page="View/Header.jsp" />
<%
    String leaveID = request.getParameter("leaveID");
    String empID = request.getParameter("empID");
    String leaveType = request.getParameter("leaveType");
    String startDate = request.getParameter("startDate");
    String endDate = request.getParameter("endDate");
    String reason = request.getParameter("reason");
%>

<div class="assign-task-section">
    <h2>Update Leave Request</h2>
    <form action="ReqLevUpdateServlet" method="post" class="assign-task-form">

        <div class="task-form-group">
            <label for="leaveid">Leave ID:</label>
            <input type="text" id="leaveid" name="leaveID" value="<%= request.getParameter("leaveID") %>" readonly>
        </div>

        <div class="task-form-group">
            <label for="empID">Employee ID:</label>
            <input type="text" id="empID" name="empID" value="<%= request.getParameter("empID") %>" required>
        </div>

        <div class="task-form-group">
            <label for="type">Leave Type:</label>
            <select id="type" name="leaveType" required>
                <option value="">Select Leave Type</option>
                <option value="annual" <%= "annual".equals(request.getParameter("leaveType")) ? "selected" : "" %>>Annual</option>
                <option value="sick" <%= "sick".equals(request.getParameter("leaveType")) ? "selected" : "" %>>Sick</option>
                <option value="casual" <%= "casual".equals(request.getParameter("leaveType")) ? "selected" : "" %>>Casual</option>
                <option value="maternity" <%= "maternity".equals(request.getParameter("leaveType")) ? "selected" : "" %>>Maternity</option>
                <option value="unpaid" <%= "unpaid".equals(request.getParameter("leaveType")) ? "selected" : "" %>>Unpaid</option>
            </select>
        </div>

        <div class="task-form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" value="<%= request.getParameter("startDate") %>" required>
        </div>

        <div class="task-form-group">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" value="<%= request.getParameter("endDate") %>" required>
        </div>

        <div class="task-form-group">
            <label for="reason">Reason:</label>
            <input type="text" id="reason" name="reason" value="<%= request.getParameter("reason") %>" required>
        </div>

        <button type="submit" class="task-submit-btn">Submit</button>
    </form>
</div>

<jsp:include page="View/Footer.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</body>
</html>
