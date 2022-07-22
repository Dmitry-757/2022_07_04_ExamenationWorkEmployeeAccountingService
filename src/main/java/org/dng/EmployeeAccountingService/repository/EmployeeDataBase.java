package org.dng.EmployeeAccountingService.repository;


import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;

import java.io.Serializable;
import java.util.HashMap;





public class EmployeeDataBase extends DataBaseAbstract<Employee> implements Serializable {
//public class EmployeeDataBase implements Serializable {
    private static final long serialVersionUID = 3L;
//    private DepartmentDataBase departmentDataBase = AppContext.getDepartmentDataBase();
//    private JobDataBase jobDataBase = AppContext.getJobDataBase();
//
//    public void setDepartmentDataBase(DepartmentDataBase departmentDataBase) {
//        this.departmentDataBase = departmentDataBase;
//    }
//
//    public void setJobDataBase(JobDataBase jobDataBase) {
//        this.jobDataBase = jobDataBase;
//    }
//
//    public DepartmentDataBase getDepartmentDataBase() {
//        return departmentDataBase;
//    }
//
//    public JobDataBase getJobDataBase() {
//        return jobDataBase;
//    }
    //    private static int maxId;
//
//    private static HashMap<String, Employee> employeeHashMap = new HashMap<>();
//
//    public static int getMaxId() {
//        return maxId;
//    }
//
//    public static void setMaxId(int maxId) {
//        EmployeeDataBase.maxId = maxId;
//    }

//    public static HashMap<String, Employee> getEmployeeHashMap() {
//        return employeeHashMap;
//    }


    //    public static void add(Employee employee) throws DataBaseAddException {
    public void put(Employee entity) throws AddDuplicatedObjException {
        if (entityHashMap.containsKey(entity.getInn())) {
            System.out.println("Employee with such INN is already present!");
            throw new AddDuplicatedObjException("Employee with such INN is already present!");
        }
        entityHashMap.put(entity.getInn(), entity);
    }

}
