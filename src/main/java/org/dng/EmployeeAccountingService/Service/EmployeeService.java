package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Employee;
import org.dng.EmployeeAccountingService.Entities.Job;
import org.dng.EmployeeAccountingService.Entities.Gender;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//public class EmployeeService implements IEmployeeService{
public class EmployeeService {

    public void addEmployee(@NotNull String fullName,
                                       int inn,
                                       LocalDate birthDate,
                                       @NotNull
                                               Gender gender,
                                       String phoneNumber,
                                       Job job,
                                       @NotNull Department department,
                                       Employee boss,
                                       @NotNull LocalDate recruitDate,
                                       LocalDate dismissDate,
                                       @NotNull int salary) {
        new Employee(fullName, inn, birthDate, gender, phoneNumber, job, department, boss, recruitDate, dismissDate, salary);
    }

    public void changeEmployee(Employee employee) {
        System.out.println("did not made yet");
    }

    public void dismissEmployee(Employee employee, LocalDate dismissDate) {
        employee.dismiss(dismissDate);
    }

    public List<Employee> findEmployee(String fullName) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
            return entityHashMap
                    .entrySet()
                    .stream()
                    .filter(e -> e.getKey().equals(fullName))
                    .map(Map.Entry::getValue)
                    .toList();
    }

    public List<Employee> findEmployee(Department department) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getDepartment().equals(department))
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Employee> findEmployee(Employee boss) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getBoss().equals(boss))
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Employee> findEmployee(final int minSalary, final int maxSalary) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> (minSalary <= e.getValue().getSalary())&&(e.getValue().getSalary()<=maxSalary) )
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Employee> findAll() {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();

        return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
    }

}
