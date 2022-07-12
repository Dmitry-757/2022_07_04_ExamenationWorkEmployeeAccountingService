package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Department;
import java.util.HashSet;
import java.util.List;

public class DepartmentDataBase {
    private static int maxId;

    private static HashSet<Department> departmentHashSet = new HashSet<>();

    public static int getMaxId() {
        return maxId;
    }

    public static void setMaxId(int maxId) {
        DepartmentDataBase.maxId = maxId;
    }

    public static HashSet<Department> getDepartmentHashSet() {
        return departmentHashSet;
    }

    //    public static void add(Employee employee) throws DataBaseAddException {
    public static void add(Department department) {
        //сначала проверим нет ли уже такого
        if (departmentHashSet.contains(department)) {
            //throw new DataBaseAddException("this employee is already present!");
            System.out.println("this employee is already present!");
            return;
        }
        departmentHashSet.add(department);
    }

    public static List<Department> findAll() {
        return departmentHashSet.stream().toList();
    }
}
