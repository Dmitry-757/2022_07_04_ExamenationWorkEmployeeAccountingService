package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Service.DepartmentService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/department")
public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> ld = DepartmentDataBase.findAll();
        if (ld.size()>0){
            request.setAttribute("departments", ld);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");//get  parameter from http request
        if(fullName != null) {
            System.out.println("fullName = "+ fullName);
            DepartmentService.addDepartment(fullName);
        }

        List<Department> ld = DepartmentDataBase.findAll();
        if (ld.size()>0){
            request.setAttribute("departments", ld);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentEdit.jsp");
        dispatcher.forward(request, response);
    }
}
