package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Model.Department;

public interface IDepartmentService {
    public void addDepartment(String name);
    public void renameDepartment(Department department);
    public void removeDepartment(Department department);
}
