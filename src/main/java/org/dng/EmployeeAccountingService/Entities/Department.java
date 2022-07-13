package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
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
        if(DepartmentDataBase.isExist(name))
            throw new AddDuplicatedObjException("Department with such name is already existed!");
        this.name = name;
        this.id = DepartmentDataBase.getMaxId()+1;
        DepartmentDataBase.setMaxId(this.id);
        DepartmentDataBase.add(this);
    }

    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;

        this.id = DepartmentDataBase.getMaxId()+1;
        DepartmentDataBase.setMaxId(this.id);
        DepartmentDataBase.add(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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
