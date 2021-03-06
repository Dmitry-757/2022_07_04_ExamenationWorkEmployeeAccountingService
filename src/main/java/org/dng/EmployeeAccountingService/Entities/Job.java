package org.dng.EmployeeAccountingService.Entities;

import org.dng.EmployeeAccountingService.AppContext;

import java.io.Serializable;

/**
 * Должность
 */
public class Job implements Serializable {
    private static final long serialVersionUID = 6L;

    private String name;
    private int id;
    private boolean deprecated;


    public Job(String name) throws AddDuplicatedObjException {
//        if(AppContext.getJobDataBase().isExist(name))
        if(AppContext.getJobService().isExist(name))
            throw new AddDuplicatedObjException("Job with such name is already exist!");
        this.name = name;
        this.id = AppContext.getJobDataBase().getMaxId()+1;
        AppContext.getJobDataBase().setMaxId(this.id);
        AppContext.getJobDataBase().put(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }
}
