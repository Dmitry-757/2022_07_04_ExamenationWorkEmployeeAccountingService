package org.dng.EmployeeAccountingService.Controllers.Reports;

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

@WebServlet(name = "EmployeeSearchServlet", value = "/reports/search")
public class EmployeeSearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        List<Department> ld = AppContext.getDepartmentService().findAll();
        if (ld.size()>0){
            req.setAttribute("departments", ld);
        }

        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            req.setAttribute("jobs", lj);
        }

//        List<Employee> le = AppContext.getEmployeeService().findAll();
//        if (le.size()>0){
//            req.setAttribute("employees", le);
//        }

        List<Employee> bosses = AppContext.getDepartmentDataBase()
                           .getEntityHashMap()
                           .entrySet()
                            .stream()
                            .map(e -> e.getValue().getBoss())
                            .distinct()
                            .filter(v->v!=null)
                            .toList();
        if (bosses.size()>0){
            req.setAttribute("bosses", bosses);
        }


        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/reports/SearchOfEmployee.jsp");
        dispatcher.forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> ld = AppContext.getDepartmentService().findAll();
        if (ld.size()>0){
            req.setAttribute("departments", ld);
        }

        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            req.setAttribute("jobs", lj);
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

        @NotNull int inn = 0;
        if(req.getParameter("inn")!=""){
            inn = Integer.parseInt(req.getParameter("inn"));
        }

//        @NotNull
//        String strGender = req.getParameter("gender");//get selectDepartment parameter from http request
//        if(fullName != null) {
//            System.out.println("gender = "+ strGender);
//        }

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


        //searching and processing of "selectDepartment" parameter
        @NotNull Department department = null;
        Employee boss = null;
        String selectDepartment = req.getParameter("selectDepartment");//get selectDepartment parameter from http request
        if(selectDepartment != null) {
            int id = Integer.parseInt(selectDepartment);
            department = AppContext.getDepartmentService().getById(id);
            //System.out.println("selectDepartment = "+ DepartmentDataBase.getById(id).getName());
            boss = department.getBoss();
        }

        @NotNull Job job = null;
        String selectJob = req.getParameter("selectJob");//get selectJob parameter from http request <select name="selectJob">
        if(selectJob != null) {
            int id = Integer.parseInt(selectJob);
            job = AppContext.getJobService().getById(id);
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
        @NotNull
        String email = req.getParameter("email");//get selectDepartment parameter from http request
        @NotNull
        String pass = req.getParameter("pass");//get selectDepartment parameter from http request


        if (fullName.length()>0) {
            assert gender != null;
            assert department != null;
            assert recruitDate != null;
            AppContext.getEmployeeService().add(fullName,
                    inn,
                    birthDate,
                    gender,
                    phoneNumber,
                    job,
                    department,
                    boss,
                    recruitDate,
                    dismissDate,
                    salary,
                    email,
                    pass);
        }

        List<Employee> le = AppContext.getEmployeeService().findAll();
        if (le.size()>0){
            req.setAttribute("employees", le);
        }

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/EmployeeNew.jsp");//get jsp-maket context
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