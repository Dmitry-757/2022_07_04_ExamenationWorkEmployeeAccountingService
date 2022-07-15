package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Service.DepartmentService;
import org.dng.EmployeeAccountingService.Service.JobService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase_old;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/department")
public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> ld = AppContext.getDepartmentDataBase().findAll();
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
            if (fullName.length()>0){
                DepartmentService.addDepartment(fullName);
            }
        }

        List<Department> ld = AppContext.getDepartmentDataBase().findAll();
        if (ld.size()>0){
            request.setAttribute("departments", ld);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentEdit.jsp");
        dispatcher.forward(request, response);
    }
}
