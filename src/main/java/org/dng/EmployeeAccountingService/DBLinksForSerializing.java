package org.dng.EmployeeAccountingService;

import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

import java.io.Serializable;

public class DBLinksForSerializing implements Serializable {

    private static final long serialVersionUID = 10L;

    private DepartmentDataBase departmentDataBase = new DepartmentDataBase();
    private JobDataBase jobDataBase = new JobDataBase();
    private EmployeeDataBase employeeDataBase = new EmployeeDataBase();

    public DBLinksForSerializing() {
        System.out.println("DBLinksForSerializing was created");
    }

    public EmployeeDataBase getEmployeeDataBase() {
        return employeeDataBase;
    }

    public DepartmentDataBase getDepartmentDataBase() {
        return departmentDataBase;
    }

    public JobDataBase getJobDataBase() {
        return jobDataBase;
    }

    public void setDepartmentDataBase(DepartmentDataBase departmentDataBase) {
        this.departmentDataBase = departmentDataBase;
    }

    public void setJobDataBase(JobDataBase jobDataBase) {
        this.jobDataBase = jobDataBase;
    }

    public void setEmployeeDataBase(EmployeeDataBase employeeDataBase) {
        this.employeeDataBase = employeeDataBase;
    }
}
