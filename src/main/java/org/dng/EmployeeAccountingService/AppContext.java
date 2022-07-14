package org.dng.EmployeeAccountingService;

import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

public class AppContext {
    private static DepartmentDataBase departmentDataBase = new DepartmentDataBase();
    private static JobDataBase jobDataBase = new JobDataBase();
    private static EmployeeDataBase employeeDataBase = new EmployeeDataBase();

    public static DepartmentDataBase getDepartmentDataBase() {
        return departmentDataBase;
    }

    public static JobDataBase getJobDataBase() {
        return jobDataBase;
    }

    public static EmployeeDataBase getEmployeeDataBase() {
        return employeeDataBase;
    }
}
