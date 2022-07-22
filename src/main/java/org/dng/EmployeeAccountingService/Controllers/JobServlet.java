package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Job;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobServlet", value = "/newjob")
public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobNew.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");//get  parameter from http request
        if(fullName != null) {
//            System.out.println("fullName = "+ fullName);
            if (fullName.length()>0){
                AppContext.getJobService().add(fullName);
            }
        }

        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobNew.jsp");
        dispatcher.forward(request, response);
    }
}
