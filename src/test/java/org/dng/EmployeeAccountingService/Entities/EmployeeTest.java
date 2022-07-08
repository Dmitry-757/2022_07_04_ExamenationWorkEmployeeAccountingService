package org.dng.EmployeeAccountingService.Entities;


import org.dng.EmployeeAccountingService.Service.EmployeeService;
import org.dng.EmployeeAccountingService.repository.DataBase;
import org.dng.EmployeeAccountingService.repository.DataBaseAddException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EmployeeTest {
    public Job job;
    public Department department;
    public Employee empl;

    @BeforeEach
    void makeEmployee() {
        try {
            job = new Job("manager");
            department = new Department("Sale department");
            empl = new Employee("Pupkin Ivan Ivanovich",
                    LocalDate.of(1970, 6, 1),
                    Sex.MALE,
                    "912-1234567",
                    job, department, null,
                    LocalDate.of(2022, 7, 8),
                    null,
                    1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Disabled
    @Test
    void addDuplicatedEmployeeToDB() {
        final Employee empl2 = empl;
        DataBase.getEmployeeHashMap().entrySet().forEach(s -> System.out.println(s.getKey() +" => "+ s.getValue()));
        Assertions.assertThrows(DataBaseAddException.class, ()->DataBase.add(empl2),"Exception must be thrown!");
    }

    @Test
    void findEmployeeTest(){
        EmployeeService.findEmployee("Pupkin Ivan Ivanovich");
    }

}