package org.dng.EmployeeAccountingService.repository;


import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Employee;

import java.io.Serializable;


public class EmployeeDataBase extends DataBaseAbstract<Employee> implements Serializable {
    private static final long serialVersionUID = 3L;
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
            System.out.println("job with such INN is already present!");
            throw new AddDuplicatedObjException("job with such INN is already present!");
        }
        entityHashMap.put(entity.getInn(), entity);
    }

}
