package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/department")
public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> ld = AppContext.getDepartmentService().findAll();
        if (ld.size()>0){
            request.setAttribute("departments", ld);
        }

        //boss
        List<Employee> le = AppContext.getEmployeeService().findAll();
        if (le.size()>0){
            request.setAttribute("bosses", le);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentNew.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullName = request.getParameter("fullName");//get  parameter from http request

        //searching and processing of "selectBoss" parameter
        @NotNull Employee boss = null;
        String selectBoss = request.getParameter("selectBoss");//get selectBoss parameter from http request
        if(selectBoss != null) {
            int id = Integer.parseInt(selectBoss);
            boss = AppContext.getEmployeeService().getById(id);
        }

        if(fullName != null) {
            //System.out.println("fullName = "+ fullName);
            if ((fullName.length() > 0) && (boss != null)) {
                AppContext.getDepartmentService().add(fullName, boss);
            } else if (fullName.length() > 0) {
                AppContext.getDepartmentService().add(fullName);
            }
        }

        List<Department> ld = AppContext.getDepartmentService().findAll();
        if (ld.size()>0){
            request.setAttribute("departments", ld);
        }

        //boss
        List<Employee> le = AppContext.getEmployeeService().findAll();
        if (le.size()>0){
            request.setAttribute("bosses", le);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentNew.jsp");
        dispatcher.forward(request, response);
    }
}
