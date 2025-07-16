package com.oop.staffManagement.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String uri = httpRequest.getRequestURI();

        boolean isLoginRequest = uri.endsWith("login.jsp");
        boolean isRegisterRequest = uri.endsWith("register.jsp");
        boolean isStaticResource = uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg");

        // Allow login, register, and static resources
        if (isLoginRequest || isRegisterRequest || isStaticResource) {
            chain.doFilter(request, response);
            return;
        }

        boolean isLoggedIn = (session != null && session.getAttribute("userRole") != null);

        if (isLoggedIn) {
        	 String role = (String) session.getAttribute("userRole");
             if ("admin".equals(role)) {
                 chain.doFilter(request, response); // Allow access
             }
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {}
}
