package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.jetbrains.annotations.NotNull;

/**
 * отдел
 */
public class Department {
    @NotNull
    private int id;
    private String Name;
    private Employee boss;
    private boolean deprecated;

    public Department(String name) {
        Name = name;

        this.id += DepartmentDataBase.getMaxId();
        DepartmentDataBase.setMaxId(this.id);
        DepartmentDataBase.add(this);
    }

    public Department(String name, Employee boss) {
        Name = name;
        this.boss = boss;

        this.id += DepartmentDataBase.getMaxId();
        DepartmentDataBase.setMaxId(this.id);
        DepartmentDataBase.add(this);
    }

    public String getName() {
        return Name;
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
}
