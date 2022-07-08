package org.dng.EmployeeAccountingService.Entities;

/**
 * отдел
 */
public class Department {
    private String Name;
    private Employee boss;
    private boolean deprecated;

    public Department(String name) {
        Name = name;
    }

    public Department(String name, Employee boss) {
        Name = name;
        this.boss = boss;
    }

    public String getName() {
        return Name;
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
