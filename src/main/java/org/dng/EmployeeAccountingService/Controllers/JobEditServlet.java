package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;
import org.dng.EmployeeAccountingService.Entities.Job;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobEditServlet", value = "/editjob")
public class JobEditServlet extends HttpServlet {
    private int editedEntityId = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> lj = AppContext.getJobService().findAll(true);
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
        String buttonAction = request.getParameter("buttonAction");

        if ("edit".equals(buttonAction)) {
            if (numChecked != null) {
                if (numChecked.length() > 0) {
                    Job entity = AppContext.getJobService().getById(Integer.parseInt(numChecked));
                    System.out.println(entity.getName());
                    editedEntityId = entity.getId();
                    request.setAttribute("fullName", entity.getName());
                    //int a = 0;

                    if (entity.isDeprecated()) {
                        request.setAttribute("selectDeprecatedId", 1);
                    } else {
                        request.setAttribute("selectDeprecatedId", 2);
                    }

                }
            }
        }
        else if((editedEntityId != 0)&&("save".equals(buttonAction))) {

            String fullName = request.getParameter("fullName");//get  parameter from http request
            if ((fullName != null) && (editedEntityId != 0)) {
                if (fullName.length() > 0) {
                    Job entity = AppContext.getJobService().getById(editedEntityId);
                    AppContext.getJobService().change(entity, fullName);

                    if (request.getParameter("selectDeprecatedId") != null) {
                        if ("deprecated".equals(request.getParameter("selectDeprecatedId"))) {
                            entity.setDeprecated(true);
                        }
                        else{
                            entity.setDeprecated(false);
                        }
                    }

                    editedEntityId = 0;
                }
            }
        }
//        else if((numChecked != null)&&("dismiss".equals(buttonAction))) {
//            if (numChecked.length() > 0) {
//                Job entity = AppContext.getJobService().getById(Integer.parseInt(numChecked));
//                entity.setDeprecated(true);
//            }
//        }

        List<Job> lj = AppContext.getJobService().findAll(true);
        if (lj.size()>0){
            request.setAttribute("jobs", lj);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/JobEdit.jsp");
        dispatcher.forward(request, response);
    }
}
