package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Department;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DepartmentDataBase extends DataBaseAbstract<Department> implements Serializable {
    private static final long serialVersionUID = 2L;

    public void put(Department department) {
        //сначала проверим нет ли уже с таким id
        if (entityHashMap.containsKey(department.getId())) {
            System.out.println("department with such Id is already present!");
            return;
        }
        entityHashMap.put(department.getId(),department);
    }

}
