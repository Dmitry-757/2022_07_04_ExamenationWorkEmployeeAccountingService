package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Department;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DepartmentDataBase {
    private static int maxId;

    private static HashMap<Integer, Department> departmentHashMap = new HashMap<>();

    public static int getMaxId() {
        return maxId;
    }

    public static void setMaxId(int maxId) {
        DepartmentDataBase.maxId = maxId;
    }

    public static HashMap<Integer, Department> getDepartmentHashMap() {
        return departmentHashMap;
    }

    public static boolean isExist(String name){
        return departmentHashMap.entrySet()
                .stream()
                .map(e -> e.getValue().getName())
                .toList()
                .contains(name);
    }

    //    public static void add(Employee employee) throws DataBaseAddException {
    public static void add(Department department) {
        //сначала проверим нет ли уже с таким id
        if (departmentHashMap.containsKey(department.getId())) {
            System.out.println("department with such Id is already present!");
            return;
        }
        departmentHashMap.put(department.getId(),department);
    }

    public static List<Department> findAll() {
        return departmentHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
    }

    public static Department getById(int id){
        return departmentHashMap.get(id);
    }

    public static Department getByName(String name){
        return departmentHashMap.entrySet()
                .stream()
                .filter(v-> v.getValue().getName().equals(name))
                .map(e -> e.getValue())
                .findFirst()
                .get();
    }

}
