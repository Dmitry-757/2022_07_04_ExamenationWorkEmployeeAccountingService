package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Model.Department;
import org.dng.EmployeeAccountingService.Model.Employee;
import org.dng.EmployeeAccountingService.repository.DataBase;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public interface IEmployeeService {
    static void recruitEmployee(Employee employee) {
    }

    static void dismissEmployee(Employee employee, LocalDate dismissDate){};
    static void changeEmployee(Employee employee){}



    static List<Employee> findEmployee(String fullName){
        HashMap<String, Employee> employeeHashMap = DataBase.getEmployeeHashMap();
        if(employeeHashMap.containsKey(fullName)){ //самый быстрый поиск - ищем фио, если такого нет то дальше искать незачем
            return employeeHashMap
                    .entrySet()
                    .stream()
                    .filter(e -> e.getKey().equals(fullName))
                    .map(Map.Entry::getValue)
                    .toList();
        }
        return null;
    }//поиск сотрудника по фио
    static List<Employee> findEmployee(Department department){return null;} //список сотрудников в отделе
    static List<Employee> findEmployee(Employee boss){return null;} //список сотрудников по начальнику
    static List<Employee> findEmployee(int minSalary, int maxSalary){return null;} //список сотрудников с зп в диапазоне

}
