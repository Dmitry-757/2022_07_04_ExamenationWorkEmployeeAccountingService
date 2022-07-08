package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Entities.Department;

public interface IDepartmentService {
    public void addDepartment(String name);
    public void renameDepartment(Department department);
    public void removeDepartment(Department department);
}
