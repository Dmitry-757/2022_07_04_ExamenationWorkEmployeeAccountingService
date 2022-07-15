package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Job;

import java.util.HashMap;
import java.util.List;

public class DepartmentService  extends ServiceAbstract<Department>{

    @Override
    public void add(String name) {
        try {
            new Department(name);
        } catch (AddDuplicatedObjException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void change(Department entity, Object ... args) {
        if (args.length==1){
            String name = (String) args[0];
            entity.setName(name);
        }
    }


    public static void remove(Department department) {
        System.out.println("may be in future ... ;))");
    }

    @Override
    public boolean isExist(String name) {
        HashMap<Integer, Department> entityHashMap = AppContext.getDepartmentDataBase().getEntityHashMap();
        return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue().getName())
                .toList()
                .contains(name);
    }


    @Override
    public List<Department> findAll() {
        HashMap<Integer, Department> entityHashMap = AppContext.getDepartmentDataBase().getEntityHashMap();
        return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
    }

    @Override
    public Department getById(int id) {
        HashMap<Integer, Department> entityHashMap = AppContext.getDepartmentDataBase().getEntityHashMap();
        return entityHashMap.get(id);
    }

    @Override
    public Department getByName(String name) {
        HashMap<Integer, Department> entityHashMap = AppContext.getDepartmentDataBase().getEntityHashMap();
        return entityHashMap.entrySet()
                .stream()
                .filter(v-> v.getValue().getName().equals(name))
                .map(e -> e.getValue())
                .findFirst()
                .get();
    }
}
