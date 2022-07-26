package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Service.SaveReadDataBase;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DepartmentDataBase extends DataBaseAbstract<Department> implements Serializable {
//public class DepartmentDataBase implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

//    protected int maxId;
//
//    protected HashMap<Integer, Department> entityHashMap = new HashMap<>();
//
//    public int getMaxId() {
//        return maxId;
//    }
//
//    public void setMaxId(int id) {
//        this.maxId = id;
//    }
//
//    public HashMap<Integer, Department> getEntityHashMap() {
//        return entityHashMap;
//    }


    public void put(Department entity) {
        //сначала проверим нет ли уже с таким id
        if (entityHashMap.containsKey(entity.getId())) {
            System.out.println("department with such Id is already present!");
            AppContext.getMyLogger(this.getClass().getName()).warning("Department with id = "+entity.getId()+" is already present");
            return;
        }
        entityHashMap.put(entity.getId(),entity);
        AppContext.getMyLogger(this.getClass().getName()).info("department "+entity.getName()+" was put to HashMap");
    }

}
