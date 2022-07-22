package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Job;

import java.io.Serializable;


public class JobDataBase extends DataBaseAbstract<Job> implements Serializable {
    private static final long serialVersionUID = 1L;
    public void put(Job entity) {
        //сначала проверим нет ли уже с таким id
        if (entityHashMap.containsKey(entity.getId())) {
//            System.out.println("job with such Id is already present!");
            AppContext.getMyLogger(this.getClass().getName()).warning("Exception during creating new Job "+entity.getName()+" with id "+entity.getId()+" is already present");
            return;
        }
        entityHashMap.put(entity.getId(),entity);
        AppContext.getMyLogger(this.getClass().getName()).info("Job "+entity.getName()+" was put to HashMap");
    }
}
