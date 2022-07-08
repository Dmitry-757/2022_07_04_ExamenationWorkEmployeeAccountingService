package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Employee;

import java.util.HashMap;

public class DataBase {
    private static int maxId;

    private static HashMap<String, Employee> employeeHashMap = new HashMap<>();

    public static int getMaxId() {
        return maxId;
    }

    public static void setMaxId(int maxId) {
        DataBase.maxId = maxId;
    }

    public static HashMap<String, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }

//    public static void add(Employee employee) throws DataBaseAddException {
    public static void add(Employee employee) {
        //сначала проверим нет ли уже такого
        if(employeeHashMap.containsKey(employee.getFullName())){ //самый быстрый поиск - ищем фио, если такого нет то дальше искать незачем
            //если фио нашлось - нужно проверить тот ли это объект (может однофамилец)
            if(employeeHashMap.entrySet()
                    .stream()
                    .anyMatch(e -> e.getValue().equals(employee))
            ){
                //throw new DataBaseAddException("this employee is already present!");
                System.out.println("this employee is already present!");
            }

        }
        employeeHashMap.put(employee.getFullName(), employee);
    }


}
