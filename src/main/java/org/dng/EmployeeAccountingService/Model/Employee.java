package org.dng.EmployeeAccountingService.Model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

/**
 * Сотрудник
 */
public class Employee {
    private static long maxId;

    @NotNull
    private long id;
    @NotNull
    private String fullName;
    private LocalDate birthDate;
    private Sex sex;
    private String phoneNumber;
    @NotNull
    private Job job;
    @NotNull
    private Department department;
    private Employee boss;
    @NotNull
    private LocalDate employmentDate;
    private LocalDate dismissDate;
    @NotNull
    private int salary;
}
