package org.dng.EmployeeAccountingService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

@WebListener
public class MyServletContext implements ServletContextListener {
    ServletContext context;

    public DepartmentDataBase departmentDataBase = new DepartmentDataBase();
    JobDataBase jobDataBase;

    public void contextInitialized(ServletContextEvent contextEvent) {
        departmentDataBase = new DepartmentDataBase();
        //jobDataBase = new JobDataBase();

        System.out.println("My Context Created !");
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {

        System.out.println("Context Destroyed");
    }
}
