package org.dng.EmployeeAccountingService.Model;

import org.dng.EmployeeAccountingService.repository.DataBase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void addDuplicatedEmployeeToDB() {
        Job job = new Job("manager");
        Department department = new Department("Sale department");
            Employee empl = new Employee("Pupkin Ivan Ivanovich",
                    LocalDate.of(1970,6,1),
                    Sex.MALE,
                    "912-1234567",
                    job, department, null,
                    LocalDate.of(2022,7,8),
                    null,
                    1000);

        try {
            empl.add();
            empl.add();
            DataBase.getEmployeeHashMap().entrySet().forEach(e -> System.out.println(e.getKey() +" => "+ e.getValue()));
        } catch (Exception e) {
            DataBase.getEmployeeHashMap().entrySet().forEach(s -> System.out.println(s.getKey() +" => "+ s.getValue()));
            System.out.println(e.getMessage());
        }
    }
}