package org.dng.EmployeeAccountingService.Model;

/**
 * отдел
 */
public class Department {
    private String Name;
    private boolean deprecated;

    public Department(String name) {
        Name = name;
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
}
