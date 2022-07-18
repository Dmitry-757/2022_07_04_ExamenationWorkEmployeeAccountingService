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

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentEditServlet", value = "/editdepartment")
public class DepartmentEditServlet extends HttpServlet {
    private int editedEntityId = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> lst = AppContext.getDepartmentService().findAll();
        if (lst.size()>0){
            request.setAttribute("entities", lst);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String[] numChecked = request.getParameterValues("checkedJobs");//get array parameters from http request
        String numChecked = request.getParameter("checkedEntity");//get parameter from http request
        if(numChecked != null) {
            if (numChecked.length() > 0) {
                Department entity = AppContext.getDepartmentService().getById(Integer.parseInt(numChecked));
                System.out.println(entity.getName());
                editedEntityId = entity.getId();
                request.setAttribute("fullName", entity.getName());
                int a = 0;
            }
        }

        String fullName = request.getParameter("fullName");//get  parameter from http request
//        String editedEntityId = request.getParameter("editedEntityId");//get  parameter from http request
        if((fullName != null)&&(editedEntityId != 0)) {
            //System.out.println("fullName = "+ fullName);
            if (fullName.length()>0){
                Department entity = AppContext.getDepartmentService().getById(editedEntityId);
                AppContext.getDepartmentService().change(entity, fullName);
                editedEntityId = 0;
            }
        }



        List<Department> lst = AppContext.getDepartmentService().findAll();
        if (lst.size()>0){
            request.setAttribute("entities", lst);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentEdit.jsp");
        dispatcher.forward(request, response);
    }
}