package org.dng.EmployeeAccountingService;

import org.dng.EmployeeAccountingService.Service.DepartmentService;
import org.dng.EmployeeAccountingService.Service.EmployeeService;
import org.dng.EmployeeAccountingService.Service.JobService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

public class AppContext {
    private static DepartmentDataBase departmentDataBase = new DepartmentDataBase();
    private static JobDataBase jobDataBase = new JobDataBase();
    private static EmployeeDataBase employeeDataBase = new EmployeeDataBase();

    private static DepartmentService departmentService = new DepartmentService();
    private static JobService jobService = new JobService();
    private static EmployeeService employeeService = new EmployeeService();

    private static DBReferenceKeeper dbReferenceKeeper = new DBReferenceKeeper();

    //references to db
    public static DBReferenceKeeper getDbReferenceKeeper() {
        return dbReferenceKeeper;
    }

    public static DepartmentDataBase getDepartmentDataBase() {
        return departmentDataBase;
    }

    public static JobDataBase getJobDataBase() {
        return jobDataBase;
    }

    public static EmployeeDataBase getEmployeeDataBase() {
        return employeeDataBase;
    }


    //Services
    public static DepartmentService getDepartmentService() {
        return departmentService;
    }

    public static JobService getJobService() {
        return jobService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }


    //**for serialize/deserialize ***
    public static void setDepartmentDataBase(DepartmentDataBase departmentDataBase) {
        AppContext.departmentDataBase = departmentDataBase;
    }
    public static void setJobDataBase(JobDataBase jobDataBase) {
        AppContext.jobDataBase = jobDataBase;
    }
    public static void setEmployeeDataBase(EmployeeDataBase employeeDataBase) {
        AppContext.employeeDataBase = employeeDataBase;
    }

}
