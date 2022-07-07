package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Model.Department;
import org.dng.EmployeeAccountingService.Model.Employee;

import java.util.List;

public interface IEmployeeService {
    public static void recruitEmployee(Employee employee) {
    };

    public void dismissEmployee(Employee employee);
    public void changeEmployee(Employee employee);



    public Employee findEmployee(String fullName);//поиск сотрудника по фио
    public List<Employee> findEmployee(Department department); //список сотрудников в отделе
    public List<Employee> findEmployee(Employee boss); //список сотрудников по начальнику
    public List<Employee> findEmployee(int minSalary, int maxSalary); //список сотрудников с зп в диапазоне

}
