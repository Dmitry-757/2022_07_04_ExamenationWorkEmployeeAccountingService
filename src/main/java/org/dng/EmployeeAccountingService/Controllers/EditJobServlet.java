package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Job;
import org.dng.EmployeeAccountingService.Service.JobService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditJobServlet", value = "/editjob")
public class EditJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> lj = AppContext.getJobDataBase().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditJob.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");//get  parameter from http request
        if(fullName != null) {
            System.out.println("fullName = "+ fullName);
            if (fullName.length()>0){
                JobService.addJob(fullName);
            }
        }

        //String[] numChecked = request.getParameterValues("checkedJobs");//get array parameters from http request
        String numChecked = request.getParameter("checkedJob");//get parameter from http request
        if(numChecked != null) {
            if (numChecked.length() > 0) {
                Job job = AppContext.getJobDataBase().getById(Integer.parseInt(numChecked));
                System.out.println(job.getName());
            }
        }



        List<Job> lj = AppContext.getJobDataBase().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditJob.jsp");
        dispatcher.forward(request, response);
    }
}
