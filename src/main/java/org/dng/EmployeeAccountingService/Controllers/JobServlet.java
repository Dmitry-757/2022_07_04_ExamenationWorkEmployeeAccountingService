package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Job;
import org.dng.EmployeeAccountingService.Service.DepartmentService;
import org.dng.EmployeeAccountingService.Service.JobService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase_old;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobServlet", value = "/job")
public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> lj = AppContext.getJobDataBase().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");//get  parameter from http request
        if(fullName != null) {
            System.out.println("fullName = "+ fullName);
            JobService.addJob(fullName);
        }

        List<Job> lj = AppContext.getJobDataBase().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobEdit.jsp");
        dispatcher.forward(request, response);
    }
}
