package org.dng.EmployeeAccountingService.Entities;


import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Service.EmployeeService;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
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
                    1234567890,
                    LocalDate.of(1970, 6, 1),
                    Gender.MALE,
                    "912-1234567",
                    job, department,
                    LocalDate.of(2022, 7, 8),
                    null,
                    1000, "abc@gmail.com","password=qwerty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    @Disabled
//    @Test
//    void addDuplicatedEmployeeToDB() {
//        final Employee empl2 = empl;
//        EmployeeDataBase.getEmployeeHashMap().entrySet().forEach(s -> System.out.println(s.getKey() +" => "+ s.getValue()));
//        Assertions.assertThrows(AddDuplicatedObjException.class, ()-> EmployeeDataBase.add(empl2),"Exception must be thrown!");
//    }

    @Test
    void findEmployeeTest(){
        AppContext.getEmployeeService().getByName("Pupkin Ivan Ivanovich");
    }

}