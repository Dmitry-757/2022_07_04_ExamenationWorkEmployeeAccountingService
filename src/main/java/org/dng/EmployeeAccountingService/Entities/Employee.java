package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Сотрудник
 */
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 8L;



    private final int id;
    private int inn;
    @NotNull
    private String fullName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    @NotNull
    private Job job;
    @NotNull
    private Department department;
//    private Employee boss;
    @NotNull
    private LocalDate recruitDate;
    private boolean dismissed;
    private LocalDate dismissDate;
    private int salary;

    public Employee(@NotNull String fullName,
                    int inn,
                    LocalDate birthDate,
                    Gender gender,
                    String phoneNumber,
                    @NotNull Job job,
                    @NotNull Department department,
//                    Employee boss,
                    @NotNull LocalDate recruitDate,
                    LocalDate dismissDate,
//                    @NotNull int salary) throws Exception {
                    int salary,
                    String email,
                    String password
                    ) throws AddDuplicatedObjException {
        this.inn = inn;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.department = department;
//        this.boss = boss;
        this.recruitDate = recruitDate;
        this.dismissDate = dismissDate;
        this.salary = salary;
        this.email = email;
        this.password = password;

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

    public String getName() {
        return fullName;
    }

    public String getEmail() {
        return email;
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
        return this.department.getBoss();
    }

    public String getBossName() {
        if(this.department.getBoss() == null) {
            return "";}

        return getBoss().fullName;
    }

    public boolean isDismissed() {
        return dismissed;
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

    public void setInn(int inn) {
        this.inn = inn;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public void setRecruitDate(LocalDate recruitDate) {
        this.recruitDate = recruitDate;
    }

    public void setDismissDate(LocalDate dismissDate) {
        if(this.dismissDate != dismissDate) {
            this.dismissDate = dismissDate;
            if (dismissDate != null) {
                AppContext.getMyLogger(this.getClass().getName()).info("Employee " + this.fullName + " was dismissed by date " + dismissDate);
            }
        }
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
        AppContext.getMyLogger(this.getClass().getName()).info("Employee "+this.fullName+" was dismissed");
    }
    public void dismiss(LocalDate dismissDate){
        dismissed = true;
        this.dismissDate = dismissDate;
        AppContext.getMyLogger(this.getClass().getName()).info("Employee "+this.fullName+" was dismissed");
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return inn == employee.inn;
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
