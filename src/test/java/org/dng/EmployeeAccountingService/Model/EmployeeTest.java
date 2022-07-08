package org.dng.EmployeeAccountingService.Model;

import org.dng.EmployeeAccountingService.repository.DataBase;
import org.dng.EmployeeAccountingService.repository.DataBaseCRUDException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void addDuplicatedEmployeeToDB() {
        Job job = new Job("manager");
        Department department = new Department("Sale department");
        Employee empl = null;
        try {
            empl = new Employee("Pupkin Ivan Ivanovich",
                    LocalDate.of(1970,6,1),
                    Sex.MALE,
                    "912-1234567",
                    job, department, null,
                    LocalDate.of(2022,7,8),
                    null,
                    1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        final Employee empl2 = empl;
        Assertions.assertThrows(DataBaseCRUDException.class, ()->DataBase.add(empl2),"Exception must be thrown!");
        DataBase.getEmployeeHashMap().entrySet().forEach(s -> System.out.println(s.getKey() +" => "+ s.getValue()));
    }
}