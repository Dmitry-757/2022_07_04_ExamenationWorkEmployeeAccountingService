package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Department;
import org.dng.EmployeeAccountingService.Entities.Job;

public class JobService {

    public static void addJob(String name) {
        try {
            new Job(name);
        } catch (AddDuplicatedObjException e) {
            System.out.println(e.getMessage());
        }
    }


//    public static void renameJob(Job job, String name) {
//        job.setName(name);
//    }


    public static void removeDepartment(Department department) {
        System.out.println("may be in future ... ;))");
    }
}
