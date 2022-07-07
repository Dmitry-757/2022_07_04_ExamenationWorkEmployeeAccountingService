package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Model.Department;
import org.dng.EmployeeAccountingService.Model.Employee;

import java.util.List;

public class EmployeeService implements IEmployeeService{

    @Override
    public void dismissEmployee(Employee employee) {

    }

    @Override
    public void changeEmployee(Employee employee) {

    }

    @Override
    public Employee findEmployee(String fullName) {
        return null;
    }

    @Override
    public List<Employee> findEmployee(Department department) {
        return null;
    }

    @Override
    public List<Employee> findEmployee(Employee boss) {
        return null;
    }

    @Override
    public List<Employee> findEmployee(int minSalary, int maxSalary) {
        return null;
    }
}
