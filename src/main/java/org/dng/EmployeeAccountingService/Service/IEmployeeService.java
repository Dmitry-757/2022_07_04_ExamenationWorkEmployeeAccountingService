package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Model.Employee;

public interface IEmployeeService {
    public void recruitEmployee(Employee employee);
    public void dismissEmployee(Employee employee);
    public void changeEmployee(Employee employee);

}
