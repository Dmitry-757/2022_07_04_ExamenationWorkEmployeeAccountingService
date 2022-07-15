package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Department;

import java.util.HashMap;
import java.util.List;

public class DepartmentDataBase extends DataBaseAbstract<Department>{
//    private static int maxId;
//    private static HashMap<Integer, Department> departmentHashMap = new HashMap<>();

//    public static int getMaxId() {
//        return maxId;
//    }
//    public static void setMaxId(int maxId) {
//        DepartmentDataBase.maxId = maxId;
//    }


//    public boolean isExist(String name){
//        return entityHashMap.entrySet()
//                .stream()
//                .map(e -> e.getValue().getName())
//                .toList()
//                .contains(name);
//    }

    //    public static void add(Employee employee) throws DataBaseAddException {
    public void put(Department department) {
        //сначала проверим нет ли уже с таким id
        if (entityHashMap.containsKey(department.getId())) {
            System.out.println("department with such Id is already present!");
            return;
        }
        entityHashMap.put(department.getId(),department);
    }

//    public List<Department> findAll() {
//        return entityHashMap.entrySet()
//                .stream()
//                .map(e -> e.getValue())
//                .toList();
//    }
//
//    public Department getById(int id){
//        return entityHashMap.get(id);
//    }
//
//    public Department getByName(String name){
//        return entityHashMap.entrySet()
//                .stream()
//                .filter(v-> v.getValue().getName().equals(name))
//                .map(e -> e.getValue())
//                .findFirst()
//                .get();
//    }

}
