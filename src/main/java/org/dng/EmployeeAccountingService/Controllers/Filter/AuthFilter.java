package org.dng.EmployeeAccountingService.Controllers.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //получение данных сессии
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        //URL Запроса/переадресации на Servlet входа
        String loginURI = request.getContextPath() + "/Login";

//        if (session.getAttribute("userRole") != null) {
//            String userRole = (String) session.getAttribute("userRole");
//        }
        //Если сессия ранее создана
        boolean loggedIn = session != null && session.getAttribute("userName") != null && session.getAttribute("userRole") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        //Если запрос пришел со страницы с входом или сессия не пуста даем добро следовать дальше
        //Если нет ридерект на страницу входа

        if (loggedIn) {
            String userRole = session.getAttribute("userRole").toString();
            String path = request.getRequestURI();
            if (path.contains("/LogOut")) {
                session.removeAttribute("userName");
                session.removeAttribute("userRole");

                response.sendRedirect(loginURI);
                return;
            }

            if (userRole.equals("onlyReports")){
                if (!path.contains("/reports")) {

                    String newPath = request.getContextPath() + "/reports/reports.jsp";
                    response.sendRedirect(newPath);
                    return;
//                        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(newPath);
//                        dispatcher.forward(request, response);
                }
//                }else if (userRole.equals("someRole")){
            }
        }

        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
            return;
        } else {
            response.sendRedirect(loginURI);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
