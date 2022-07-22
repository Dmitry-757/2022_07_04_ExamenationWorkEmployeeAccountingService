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
import java.util.ArrayList;
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

        List<Employee> le = AppContext.getEmployeeService().findAll();
        if (le.size()>0){
            req.setAttribute("employees", le);
        }


        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/reports/SearchOfEmployee.jsp");
        dispatcher.forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String action = req.getParameter("ButtonAction");
        List<Employee> le = new ArrayList<>();

        if("ShowAll".equals(action)) {
            le = AppContext.getEmployeeService().findAll();
            if (le.size()>0){
                req.setAttribute("employees", le);
            }
        }

        else if("search".equals(action)) {

            //searching employers by department
            Department department = null;
            String selectDepartment = req.getParameter("selectDepartment");//get selectDepartment parameter from http request
            if ((selectDepartment != null) && (selectDepartment.length() != 0)) {
                int id = Integer.parseInt(selectDepartment);
                department = AppContext.getDepartmentService().getById(id);

                le = AppContext.getEmployeeService().findEmployee(department);
            }

            //searching employers by job
            Job job = null;
            String selectJob = req.getParameter("selectJob");//get selectJob parameter from http request <select name="selectJob">
            if ((selectJob != null) && (selectJob.length() != 0) ) {
                int id = Integer.parseInt(selectJob);
                job = AppContext.getJobService().getById(id);
                //if can`t find by previous parameter - let`s find by job (use template of chain ;))
                if (le.size()==0){
                    le = AppContext.getEmployeeService().findEmployee(job);
                }
                else{
                    final Job fjob = job;
                    le = le.stream()
                            .filter(v -> v.getJob().equals(fjob))
                            .toList();
                }
            }

            //searching employers by boss
            Employee boss = null;
            String selectBoss = req.getParameter("selectBoss");//get selectBoss parameter from http request <select name="selectBoss">
            if ((selectBoss != null) && (selectBoss.length() != 0) ) {
                int id = Integer.parseInt(selectBoss);
                boss = AppContext.getEmployeeService().getById(id);
                //if can`t find by previous parameter - let`s find by boss (use template of chain ;))
                if (le.size()==0){
                    le = AppContext.getEmployeeService().findEmployee(boss);
                }
                else{
                    final Employee fboss = boss;
                    le = le.stream()
                            .filter(v -> v.getBoss().equals(fboss))
                            .toList();
                }
            }

        }//if("search".equals(action))



        List<Department> ld = AppContext.getDepartmentService().findAll();
        if (ld.size()>0){
            req.setAttribute("departments", ld);
        }

        List<Job> lj = AppContext.getJobService().findAll();
        if (lj.size()>0){
            req.setAttribute("jobs", lj);
        }

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




        if (le.size()>0){
            req.setAttribute("employees", le);
        }


        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/reports/SearchOfEmployee.jsp");//get jsp-layout context
        dispatcher.forward(req, resp);//forward our data to jsp-page

    }



    public void destroy() {
    }
}