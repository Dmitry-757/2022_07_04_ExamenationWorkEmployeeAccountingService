package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;


import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;

public class DepartmentService  implements ServiceI<Department> {

    @Override
//    public void add(String name) {
    public void add(Object ...args) {
        if (args.length==1) {
            String name = (String) args[0];
            try {
                new Department(name);
            } catch (AddDuplicatedObjException e) {
                //System.out.println(e.getMessage());
                AppContext.getMyLogger(this.getClass().getName()).warning("Exception during creating new Department "+name+" "+e.getMessage());
            }
        }
        else if (args.length==2) {
            String name = (String) args[0];
            Employee boss = (Employee) args[1];
            try {
                new Department(name, boss);
            } catch (AddDuplicatedObjException e) {
//                System.out.println(e.getMessage());
                AppContext.getMyLogger(this.getClass().getName()).warning("Exception during creating new Department "+name+" "+e.getMessage());
            }
        }
    }



    @Override
    public void change(Department entity, Object ... args) {
        if (args.length==1){
            String name = (String) args[0];
            entity.setName(name);
            AppContext.getMyLogger(this.getClass().getName()).info("Department "+entity.getName()+" was changed to "+name);
        }
    }


    public void remove(Department entity) {
        System.out.println("may be in future ... ;))");
//        AppContext.getMyLogger(this.getClass().getName()).info("Department "+entity.getName()+" was removed");
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
    public List<Department> findAll(boolean showDeprecated) {
        HashMap<Integer, Department> entityHashMap = AppContext.getDepartmentDataBase().getEntityHashMap();
        if (showDeprecated)
            return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
//                .filter(e->!e.isDeprecated())
                .toList();
        else
            return entityHashMap.entrySet()
                    .stream()
                    .map(e -> e.getValue())
                    .filter(e->!e.isDeprecated())
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

    public IntSummaryStatistics getSummaryStatistics(Department entity) {
        IntSummaryStatistics stats =
                AppContext.getEmployeeService().findEmployee(entity)
                .stream()
                .map(e->e.getSalary())
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        return stats;
    }

}
