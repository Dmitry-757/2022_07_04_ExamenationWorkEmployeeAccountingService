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
        Department department = new Department("Kontora");
        List<Department> ld = DepartmentDataBase.findAll();
        request.setAttribute("departments", ld);


//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/cars.jsp");
//        dispatcher.forward(req, resp);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/RecruitEmployee.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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