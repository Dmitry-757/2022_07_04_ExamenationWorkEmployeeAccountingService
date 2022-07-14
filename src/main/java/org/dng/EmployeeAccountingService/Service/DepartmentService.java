package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;

public class DepartmentService {

    public static void addDepartment(String name) {
        try {
            new Department(name);
        } catch (AddDuplicatedObjException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addDepartment(String name, Employee boss) {
        try {
            new Department(name, boss);
        } catch (AddDuplicatedObjException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setDepartmentBoss(Department department, Employee boss) {
        department.setBoss(boss);
    }



    public static void renameDepartment(Department department, String name) {
        department.setName(name);
    }


    public static void removeDepartment(Department department) {

    }
}
