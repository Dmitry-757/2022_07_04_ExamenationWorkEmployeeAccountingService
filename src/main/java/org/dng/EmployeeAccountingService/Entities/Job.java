package org.dng.EmployeeAccountingService.Entities;

/**
 * Должность
 */
public class Job {
    private String name;

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
