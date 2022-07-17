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

@WebServlet(name = "JobEditServlet", value = "/editjob")
public class JobEditServlet extends HttpServlet {
    private int editedEntityId = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String[] numChecked = request.getParameterValues("checkedJobs");//get array parameters from http request
        String numChecked = request.getParameter("checkedJob");//get parameter from http request
        if(numChecked != null) {
            if (numChecked.length() > 0) {
                Job job = AppContext.getJobService().getById(Integer.parseInt(numChecked));
                System.out.println(job.getName());
                editedEntityId = job.getId();
                request.setAttribute("fullName", job.getName());
                //int a = 0;
            }
        }

        String fullName = request.getParameter("fullName");//get  parameter from http request
//        String editedEntityId = request.getParameter("editedEntityId");//get  parameter from http request
        if((fullName != null)&&(editedEntityId != 0)) {
            //System.out.println("fullName = "+ fullName);
            if (fullName.length()>0){
                Job job = AppContext.getJobService().getById(editedEntityId);
                AppContext.getJobService().change(job, fullName);
                editedEntityId = 0;
            }
        }



        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobEdit.jsp");
        dispatcher.forward(request, response);
    }
}
