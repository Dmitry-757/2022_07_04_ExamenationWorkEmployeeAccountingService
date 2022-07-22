package org.dng.EmployeeAccountingService;

import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

import java.io.Serializable;

/**
 * this class use only for serialize/deserialize aim
 * before begin serialize, references to dataBases are filled,
 * then, serialize process is called
 * In other case, during deserialize this references are filled from file
 * and then we can put them to main system
 */
public class DBReferenceKeeper implements Serializable {
    private static final long serialVersionUID = 10L;

    private DepartmentDataBase departmentDataBase;
    private JobDataBase jobDataBase;
    private EmployeeDataBase employeeDataBase;

    public static final String fileNameDBReferenceKeeper = "d:\\DBReferenceKeeper.sav";


    public DepartmentDataBase getDepartmentDataBase() {
        return departmentDataBase;
    }

    public JobDataBase getJobDataBase() {
        return jobDataBase;
    }

    public EmployeeDataBase getEmployeeDataBase() {
        return employeeDataBase;
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
