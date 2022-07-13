package org.dng.EmployeeAccountingService.Controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;

@WebServlet(name = "recruitServlet", value = "/recruit")
public class RecruitEmployeeServlet extends HttpServlet {
//    private String message;
//    public void init() {
//        message = "Hello World from servlet ;) !";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Department d1 = new Department("Kontora");
//        Department d2 = new Department("Buh");
        List<Department> ld = DepartmentDataBase.findAll();
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
        List<Department> ld = DepartmentDataBase.findAll();
        if (ld.size()>0){
            req.setAttribute("departments", ld);
        }

        //searching and processing of "selectDepartment" parameter
        String selectDepartment = req.getParameter("selectDepartment");//get selectDepartment parameter from http request
        if(selectDepartment != null) {
            int id = Integer.parseInt(selectDepartment);
            System.out.println("selectDepartment = "+ DepartmentDataBase.getById(id).getName());
        }

//        String[] selectDepartments = req.getParameterValues("selectDepartment");
//        for (String d:selectDepartments) {
//            System.out.println(d);
//        }

        String fullName = req.getParameter("fullName");//get selectDepartment parameter from http request
        if(fullName != null) {
            System.out.println("fullName = "+ fullName);
        }

        String gender = req.getParameter("gender");//get selectDepartment parameter from http request
        if(fullName != null) {
            System.out.println("gender = "+ gender);
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