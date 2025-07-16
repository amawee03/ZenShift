<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="header">
    <div class="logo">
        <i class="fas fa-briefcase"></i> ZenShift
    </div>
    <nav>
        <ul>
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="people.jsp">People</a></li>
            <li><a href="display.jsp">Pay</a></li>
            <li><a href="LeaveList.jsp">Leaves</a></li>
            <li><a href="Tasks.jsp">Tasks</a></li>   
        </ul>
    </nav>
    <div class="profile-icon">
        <!-- Show Admin Dashboard only if user is admin -->
        <c:if test="${sessionScope.userRole == 'admin'}">
            <a href="adminDashboard.jsp">
                <div class="profile-pic">
                    <i class="fas fa-user-shield"></i> Admin
                </div>
            </a>
        </c:if>

        <!-- Show User Dashboard for regular users -->
        <c:if test="${sessionScope.userRole != 'admin'}">
            <a href="userDashboard.jsp">
                <div class="profile-pic">
                    <i class="fas fa-user-circle"></i>
                </div>
            </a>
        </c:if>

        <!-- Logout Link -->
        <a href="LogoutServlet" class="logout-link">
            <div class="profile-pic">
                <i class="fas fa-sign-out-alt"></i>
            </div>
        </a>
    </div>
</header>
