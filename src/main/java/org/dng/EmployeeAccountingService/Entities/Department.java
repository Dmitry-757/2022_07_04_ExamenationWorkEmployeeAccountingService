package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.MyServletContext;
import org.dng.EmployeeAccountingService.repository.DataBaseAbstract;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase_old;
import org.jetbrains.annotations.NotNull;

/**
 * отдел
 */
public class Department {
    @NotNull
    private int id;
    private String name;
    private Employee boss;
    private boolean deprecated;

    public Department(String name) throws AddDuplicatedObjException {
        if(AppContext.getDepartmentDataBase().isExist(name))
            throw new AddDuplicatedObjException("Department with such name is already exist!");
        this.name = name;
        this.id = AppContext.getDepartmentDataBase().getMaxId()+1;
        AppContext.getDepartmentDataBase().setMaxId(this.id);
        AppContext.getDepartmentDataBase().add(this);
    }

    public Department(String name, Employee boss) throws AddDuplicatedObjException {
        if(AppContext.getDepartmentDataBase().isExist(name))
            throw new AddDuplicatedObjException("Department with such name is already exist!");

        this.name = name;
        this.boss = boss;

        this.id = AppContext.getDepartmentDataBase().getMaxId()+1;
        AppContext.getDepartmentDataBase().setMaxId(this.id);
        AppContext.getDepartmentDataBase().add(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee getBoss() {
        return boss;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public void setName(String name) {
        this.name = name;
    }
}
