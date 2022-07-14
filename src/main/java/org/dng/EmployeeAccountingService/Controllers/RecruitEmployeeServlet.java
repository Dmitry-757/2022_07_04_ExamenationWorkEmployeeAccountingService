package org.dng.EmployeeAccountingService.Controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;
import org.dng.EmployeeAccountingService.Entities.Gender;
import org.dng.EmployeeAccountingService.Entities.Job;
import org.dng.EmployeeAccountingService.Service.EmployeeService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase_old;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.jetbrains.annotations.NotNull;

@WebServlet(name = "recruitServlet", value = "/recruit")
public class RecruitEmployeeServlet extends HttpServlet {
//    private String message;
//    public void init() {
//        message = "Hello World from servlet ;) !";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Department d1 = new Department("Kontora");
//        Department d2 = new Department("Buh");
        List<Department> ld = DepartmentDataBase_old.findAll();
        if (ld.size()>0) {
            request.setAttribute("departments", ld);
        }


//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
//        dispatcher.forward(req, resp);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EmployeeEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> ld = DepartmentDataBase_old.findAll();
        if (ld.size()>0){
            req.setAttribute("departments", ld);
        }


//        String[] selectDepartments = req.getParameterValues("selectDepartment");
//        for (String d:selectDepartments) {
//            System.out.println(d);
//        }
        @NotNull
        String fullName = req.getParameter("fullName");//get selectDepartment parameter from http request
        if(fullName != null) {
            System.out.println("fullName = "+ fullName);
        }

        @NotNull
        String strGender = req.getParameter("gender");//get selectDepartment parameter from http request
        if(fullName != null) {
            System.out.println("gender = "+ strGender);
        }

        LocalDate birthDate = null;
        if(req.getParameter("birthDate")!=""){
            birthDate = LocalDate.parse(req.getParameter("birthDate"));
        }

        @NotNull
        Gender gender = null;
        if(req.getParameter("gender")!=""){
            switch (req.getParameter("gender")){
                case "male" -> gender = Gender.MALE;
                case "female" -> gender = Gender.FEMALE;
            }
        }

        String phoneNumber = null;
        if(req.getParameter("phoneNumber")!=""){
            phoneNumber = req.getParameter("phoneNumber");
        }

        //@NotNull
        Job job = null;
        if(req.getParameter("job")!=""){
        }

        //searching and processing of "selectDepartment" parameter
        @NotNull Department department = null;
        Employee boss = null;
        String selectDepartment = req.getParameter("selectDepartment");//get selectDepartment parameter from http request
        if(selectDepartment != null) {
            int id = Integer.parseInt(selectDepartment);
            department = DepartmentDataBase_old.getById(id);
            //System.out.println("selectDepartment = "+ DepartmentDataBase.getById(id).getName());
            boss = department.getBoss();
        }


        @NotNull LocalDate recruitDate = null;
        if(req.getParameter("recruitDate")!=""){
            recruitDate = LocalDate.parse(req.getParameter("recruitDate"));
        }

        LocalDate dismissDate = null;
        @NotNull int salary = 0;
        if(req.getParameter("salary")!=""){
            salary = Integer.parseInt(req.getParameter("salary"));
        }

        EmployeeService.addEmployee(fullName,
                 birthDate,
                gender,
                phoneNumber,
                job,
                department,
                boss,
                recruitDate,
                dismissDate,
        salary);


        List<Employee> le = EmployeeDataBase.findAll();
        if (le.size()>0){
            req.setAttribute("employees", le);
        }

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/EmployeeEdit.jsp");//get jsp-maket context
        dispatcher.forward(req, resp);//forward our data to jsp-page

        /*
        //searching and processing of "tax rate" parameter
        String sTaxRate = req.getParameter("taxRate");//get taxRate parameter from http request
        if(sTaxRate != null) {
            double tax = Double.parseDouble(sTaxRate);//cast it to double
            CarsRepository.setTax(tax);//set new tax rate to cars

            req.setAttribute("taxRate", Car.getTaxRate());//set new value of tax rate to request attribute

            List<Car> lc = CarsRepository.findAll();//get list of cars-objects
            req.setAttribute("cars", lc);//pass it to jsp-attribute
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");//get jsp-maket context
            dispatcher.forward(req, resp);//forward our data to jsp-page
        }

        //searching and processing of "number of created cars" parameter
        String sNumCar = req.getParameter("numCar");
        if(sNumCar != null) {
            int nCars = Integer.parseInt(sNumCar);
            if(nCars >= 0) {
                CarsRepository.makeNCars(nCars);//creat nCars objects of Cars

                //renew data for user in http
                req.setAttribute("taxRate", Car.getTaxRate());
                List<Car> lc = CarsRepository.findAll();
                req.setAttribute("cars", lc);
            }
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
            dispatcher.forward(req, resp);
        }
    */
    }



    public void destroy() {
    }
}