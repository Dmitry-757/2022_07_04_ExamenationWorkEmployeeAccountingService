package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Сотрудник
 */
public class Employee {

    @NotNull
    private int id;
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
    private LocalDate recruitDate;
    private boolean dismissed;
    private LocalDate dismissDate;
    @NotNull
    private int salary;

    public Employee(@NotNull String fullName,
                    LocalDate birthDate,
                    Sex sex,
                    String phoneNumber,
                    @NotNull Job job,
                    @NotNull Department department,
                    Employee boss,
                    @NotNull LocalDate recruitDate,
                    LocalDate dismissDate,
//                    @NotNull int salary) throws Exception {
                    @NotNull int salary) {
        this.id += EmployeeDataBase.getMaxId();
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.department = department;
        this.boss = boss;
        this.recruitDate = recruitDate;
        this.dismissDate = dismissDate;
        this.salary = salary;

        EmployeeDataBase.setMaxId(this.id);
        EmployeeDataBase.add(this);
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Job getJob() {
        return job;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee getBoss() {
        return boss;
    }

    public LocalDate getRecruitDate() {
        return recruitDate;
    }

    public LocalDate getDismissDate() {
        return dismissDate;
    }

    public int getSalary() {
        return salary;
    }

    public void dismiss(LocalDate dismissDate){
        dismissed = true;
        this.dismissDate = dismissDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
