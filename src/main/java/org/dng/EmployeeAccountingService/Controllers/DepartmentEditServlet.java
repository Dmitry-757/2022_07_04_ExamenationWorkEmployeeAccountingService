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
import org.dng.EmployeeAccountingService.Entities.Gender;
import org.dng.EmployeeAccountingService.Entities.Job;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentEditServlet", value = "/editdepartment")
public class DepartmentEditServlet extends HttpServlet {
    private int editedEntityId = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //there it needs to show all, including dismissed
        List<Department> lst = AppContext.getDepartmentService().findAll(true);
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
        String buttonAction = request.getParameter("buttonAction");


        if ("edit".equals(buttonAction)) {
            if (numChecked != null) {
                if (numChecked.length() > 0) {
                    Department entity = AppContext.getDepartmentService().getById(Integer.parseInt(numChecked));
                    System.out.println(entity.getName());
                    editedEntityId = entity.getId();
                    request.setAttribute("fullName", entity.getName());
                    int a = 0;

                    //boss
                    List<Employee> le = AppContext.getEmployeeService().findAll(false);
                    if (le.size() > 0) {
                        request.setAttribute("bosses", le);
                    }
                    request.setAttribute("selectedBossId", entity.getId());

                    if (entity.isDeprecated()){
                        request.setAttribute("selectDeprecatedId", 1);
                    }
                    else {
                        request.setAttribute("selectDeprecatedId", 2);
                    }

                }
            }


            String fullName = request.getParameter("fullName");//get  parameter from http request
            if ((fullName != null) && (editedEntityId != 0)) {
                if (fullName.length() > 0) {
                    Department entity = AppContext.getDepartmentService().getById(editedEntityId);
                    AppContext.getDepartmentService().change(entity, fullName);
//                    editedEntityId = 0;
                }
            }
        }

        else if((editedEntityId != 0)&&("save".equals(buttonAction))) {
                Department entity = AppContext.getDepartmentService().getById(editedEntityId);

                //searching and processing of "selectBoss" parameter
                @NotNull Employee boss = null;
                String selectBoss = request.getParameter("selectBoss");//get selectBoss parameter from http request
                if ((selectBoss != null) && (selectBoss.length() > 0)) {
                    int id = Integer.parseInt(selectBoss);
                    boss = AppContext.getEmployeeService().getById(id);
                }
                entity.setBoss(boss);

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



        //there it needs to show all, including dismissed
        List<Department> lst = AppContext.getDepartmentService().findAll(true);
        if (lst.size()>0){
            request.setAttribute("entities", lst);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DepartmentEdit.jsp");
        dispatcher.forward(request, response);
    }
}
