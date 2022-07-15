package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Сотрудник
 */
public class Employee {

    @NotNull
    private final int id;
    @NotNull
    private final int inn;
    @NotNull
    private final String fullName;
    private final LocalDate birthDate;
    private final Gender gender;
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
                    int inn,
                    LocalDate birthDate,
                    Gender gender,
                    String phoneNumber,
                    Job job,
                    @NotNull Department department,
                    Employee boss,
                    @NotNull LocalDate recruitDate,
                    LocalDate dismissDate,
//                    @NotNull int salary) throws Exception {
                    @NotNull int salary) {
        this.inn = inn;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.department = department;
        this.boss = boss;
        this.recruitDate = recruitDate;
        this.dismissDate = dismissDate;
        this.salary = salary;

        this.id = AppContext.getEmployeeDataBase().getMaxId()+1;
        AppContext.getEmployeeDataBase().setMaxId(this.id);
        AppContext.getEmployeeDataBase().put(this);
    }

    public int getId() {
        return id;
    }

    public int getInn() {
        return inn;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
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

    public String getBossName() {
        if(boss == null) {
            return "";}

        return boss.fullName;
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

    public String getStatus() {
        if (dismissed){
            return "Dismissed";
        }
        return "in service";
    }
}
