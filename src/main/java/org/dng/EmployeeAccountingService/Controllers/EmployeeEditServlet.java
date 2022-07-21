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
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "EmployeeEditServlet", value = "/editemployee")
public class EmployeeEditServlet extends HttpServlet {
    private int editedEntityId = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> lst = AppContext.getEmployeeService().findAll();
        if (lst.size()>0){
            request.setAttribute("entities", lst);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EmployeeEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        //String[] numChecked = request.getParameterValues("checkedJobs");//get array parameters from http request
        String numChecked = req.getParameter("checkedEntity");//get parameter from http request
        String action = req.getParameter("buttonaction");

        if((numChecked != null)&&("dismiss".equals(action))) {
            if (numChecked.length() > 0) {
                Employee entity = AppContext.getEmployeeService().getById(Integer.parseInt(numChecked));
                entity.setDismissed(true);
            }
        }


        if((numChecked != null)&&("edit".equals(action))) {
            if (numChecked.length() > 0) {
                Employee entity = AppContext.getEmployeeService().getById(Integer.parseInt(numChecked));
                System.out.println(entity.getName());
                editedEntityId = entity.getId();
                //set attributes
                req.setAttribute("fullName", entity.getName());
                req.setAttribute("email", entity.getEmail());
                req.setAttribute("pass", "");

                req.setAttribute("inn", entity.getInn());
                if (entity.getGender() == Gender.MALE){
                    req.setAttribute("selectedGenderId", 1);
                }
                else {
                    req.setAttribute("selectedGenderId", 2);
                }

                req.setAttribute("birthDate", entity.getBirthDate());
                req.setAttribute("phoneNumber", entity.getPhoneNumber());

                //department
                List<Department> ld = AppContext.getDepartmentService().findAll();
                if (ld.size()>0){
                    req.setAttribute("departments", ld);
                }
                req.setAttribute("selectedDepartmentId", entity.getDepartment().getId());

                //job
                List<Job> lj = AppContext.getJobService().findAll();
                if (lj.size()>0){
                    req.setAttribute("jobs", lj);
                }
                req.setAttribute("selectedJobId", entity.getJob().getId());


                req.setAttribute("recruitDate", entity.getRecruitDate());
                req.setAttribute("salary", entity.getSalary());
                //int a = 0;
            }
        }

//        //getting attributes end save it to employee

        if ("save".equals(action)) {
            @NotNull
            String fullName = req.getParameter("fullName");//get selectDepartment parameter from http request
            if (fullName != null) {
                System.out.println("fullName = " + fullName);
            }

            @NotNull
            String email = req.getParameter("email");//get selectDepartment parameter from http request
            @NotNull
            String pass = req.getParameter("pass");//get selectDepartment parameter from http request


            @NotNull int inn = 0;
            String innP = req.getParameter("inn");
            if (innP != null) {
                inn = Integer.parseInt(innP);
            }


            LocalDate birthDate = null;
            if (req.getParameter("birthDate") != null) {
                birthDate = LocalDate.parse(req.getParameter("birthDate"));
            }

            @NotNull
            Gender gender = null;
            if (req.getParameter("gender") != null) {
                switch (req.getParameter("gender")) {
                    case "male" -> gender = Gender.MALE;
                    case "female" -> gender = Gender.FEMALE;
                }
            }

            String phoneNumber = null;
            if (req.getParameter("phoneNumber") != null) {
                phoneNumber = req.getParameter("phoneNumber");
            }


            //searching and processing of "selectDepartment" parameter
            @NotNull Department department = null;
            Employee boss = null;
            String selectDepartment = req.getParameter("selectDepartment");//get selectDepartment parameter from http request
            if (selectDepartment != null) {
                int id = Integer.parseInt(selectDepartment);
                department = AppContext.getDepartmentService().getById(id);
                //System.out.println("selectDepartment = "+ DepartmentDataBase.getById(id).getName());
                boss = department.getBoss();
            }

            @NotNull Job job = null;
            String selectJob = req.getParameter("selectJob");//get selectJob parameter from http request <select name="selectJob">
            if (selectJob != null) {
                int id = Integer.parseInt(selectJob);
                job = AppContext.getJobService().getById(id);
            }


            @NotNull LocalDate recruitDate = null;
            if (req.getParameter("recruitDate") != null) {
                recruitDate = LocalDate.parse(req.getParameter("recruitDate"));
            }

            LocalDate dismissDate = null;
            @NotNull int salary = 0;
            if (req.getParameter("salary") != null) {
                salary = Integer.parseInt(req.getParameter("salary"));
            }


//        String editedEntityId = request.getParameter("editedEntityId");//get  parameter from http request
            if ((fullName != null) && (editedEntityId != 0)) {
                //System.out.println("fullName = "+ fullName);
                if (fullName.length() > 0) {
                    Employee entity = AppContext.getEmployeeService().getById(editedEntityId);
                    if (fullName.length() > 0) {
                        assert gender != null;
                        assert department != null;
                        assert recruitDate != null;
                        AppContext.getEmployeeService().change(entity,
                                fullName,
                                inn,
                                birthDate,
                                gender,
                                phoneNumber,
                                job,
                                department,
//                                boss,
                                recruitDate,
                                dismissDate,
                                salary,
                                email,
                                pass);
                    }


                    editedEntityId = 0;
                }
            }
        }




        List<Employee> lst = AppContext.getEmployeeService().findAll();
        if (lst.size()>0){
            req.setAttribute("entities", lst);
        }

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/EmployeeEdit.jsp");
        dispatcher.forward(req, response);
    }
}
