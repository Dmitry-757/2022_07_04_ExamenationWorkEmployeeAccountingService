package org.dng.EmployeeAccountingService;

import org.dng.EmployeeAccountingService.Service.DepartmentService;
import org.dng.EmployeeAccountingService.Service.EmployeeService;
import org.dng.EmployeeAccountingService.Service.JobService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

import java.net.URI;

public class AppContext {

//    private static DepartmentDataBase departmentDataBase = new DepartmentDataBase();
//    private static JobDataBase jobDataBase = new JobDataBase();
//    private static EmployeeDataBase employeeDataBase = new EmployeeDataBase();

    private static DBLinksForSerializing dbLinksForSerializing = new DBLinksForSerializing();


    private static DepartmentService departmentService = new DepartmentService();
    private static JobService jobService = new JobService();
    private static EmployeeService employeeService = new EmployeeService();


    public static DBLinksForSerializing getDbLinksForSerializing() {
        return dbLinksForSerializing;
    }

    // DataBase getters
    public static DepartmentDataBase getDepartmentDataBase() {
//        return departmentDataBase;
        return dbLinksForSerializing.getDepartmentDataBase();
    }

    public static JobDataBase getJobDataBase() {
        //return jobDataBase;
        return dbLinksForSerializing.getJobDataBase();
    }

    public static EmployeeDataBase getEmployeeDataBase() {
//        return employeeDataBase;
        return dbLinksForSerializing.getEmployeeDataBase();
    }


    //services getters
    public static DepartmentService getDepartmentService() {
        return departmentService;
    }

    public static JobService getJobService() {
        return jobService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }


    //**serialize/deserialize ***
    public static final String fileNameDBDepartment = "d:\\Department.sav";
    public static final String fileNameDBJob = "d:\\Job.sav";
    public static final String fileNameDBEmployee = "d:\\Employee.sav";
    public static final String fileNamedbLinksForSerializing = "d:\\dbLinksForSerializing.sav";


    public static void setDepartmentDataBase(DepartmentDataBase departmentDataBase) {
        //AppContext.departmentDataBase = departmentDataBase;
        dbLinksForSerializing.setDepartmentDataBase(departmentDataBase);
    }

    public static void setJobDataBase(JobDataBase jobDataBase) {
        //AppContext.jobDataBase = jobDataBase;
        dbLinksForSerializing.setJobDataBase(jobDataBase);
    }

    public static void setEmployeeDataBase(EmployeeDataBase employeeDataBase) {
        //AppContext.employeeDataBase = employeeDataBase;
        dbLinksForSerializing.setEmployeeDataBase(employeeDataBase);
    }

    public static void setDbLinksForSerializing(DBLinksForSerializing dbLinksForSerializing) {
        AppContext.dbLinksForSerializing = dbLinksForSerializing;
    }
}
