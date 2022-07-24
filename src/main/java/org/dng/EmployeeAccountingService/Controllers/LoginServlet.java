package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/Login")
//@WebServlet(name = "LoginServlet", value = "/")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (userName.equals("admin")&&(password.equals("qwerty"))){
            session.setAttribute("userName", userName);
            session.setAttribute("userRole","admin");
            response.sendRedirect("MainMenu.jsp");
        }else if (userName.equals("user")&&(password.equals("123"))){
            session.setAttribute("userName", userName);
            session.setAttribute("userRole","onlyReports");
            response.sendRedirect("MainMenu.jsp");
        }
        else{
            response.sendRedirect("Login.jsp");
        }


//        UsersService usersService = new UsersService();
//        int id_user = usersService.getRoleUser(userName, password);
//        if (id_user != 0) {
//            Users user = usersService.getUserById(id_user);
//            if (user.getRole().equals("user")) {
//                session.setAttribute("userName", userName);
//                session.setAttribute("name",user.getFio_user());
////                response.sendRedirect("userview/user.jsp");
//            }
//            if (user.getRole().equals("admin")) {
////                response.sendRedirect("adminview/admin.jsp");
//                response.sendRedirect("index.jsp");
//            }
//        }else
//        {
//            response.sendRedirect("index.jsp");
//        }
    }
}
