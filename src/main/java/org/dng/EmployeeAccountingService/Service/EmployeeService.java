package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;
import org.dng.EmployeeAccountingService.Entities.Job;
import org.dng.EmployeeAccountingService.Entities.Sex;
import org.dng.EmployeeAccountingService.repository.DataBase;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//public class EmployeeService implements IEmployeeService{
public class EmployeeService {

    public static void recruitEmployee(@NotNull String fullName,
                                       LocalDate birthDate,
                                       @NotNull
                                       Sex sex,
                                       String phoneNumber,
                                       @NotNull Job job,
                                       @NotNull Department department,
                                       Employee boss,
                                       @NotNull LocalDate recruitDate,
                                       LocalDate dismissDate,
                                       @NotNull int salary) {
        new Employee(fullName, birthDate, sex, phoneNumber, job, department, boss, recruitDate, dismissDate, salary);
    }

    public static void changeEmployee(Employee employee) {
    }

    public static void dismissEmployee(Employee employee, LocalDate dismissDate) {
        employee.dismiss(dismissDate);
    }

    public static List<Employee> findEmployee(String fullName) {
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
    }

    public static List<Employee> findEmployee(Department department) {
        HashMap<String, Employee> employeeHashMap = DataBase.getEmployeeHashMap();
        return employeeHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getDepartment().equals(department))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<Employee> findEmployee(Employee boss) {
        HashMap<String, Employee> employeeHashMap = DataBase.getEmployeeHashMap();
        return employeeHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getBoss().equals(boss))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<Employee> findEmployee(final int minSalary, final int maxSalary) {
        HashMap<String, Employee> employeeHashMap = DataBase.getEmployeeHashMap();
        return employeeHashMap
                .entrySet()
                .stream()
                .filter(e -> (minSalary <= e.getValue().getSalary())&&(e.getValue().getSalary()<=maxSalary) )
                .map(Map.Entry::getValue)
                .toList();
    }
}
