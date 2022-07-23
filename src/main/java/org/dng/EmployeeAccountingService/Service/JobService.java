package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Job;

import java.util.HashMap;
import java.util.List;

public class JobService implements ServiceI<Job> {

    public void add(Object ...args) {
        if (args.length>0) {
            String name = (String) args[0];
            try {
                new Job(name);
            } catch (AddDuplicatedObjException e) {
//                System.out.println(e.getMessage());
                AppContext.getMyLogger(this.getClass().getName()).warning("Exception during creating new Job "+name+" "+e.getMessage());
            }
        }
    }

    @Override
    public void change(Job entity, Object ... args) {
        if (args.length==1){
            String name = (String) args[0];
            entity.setName(name);
            AppContext.getMyLogger(this.getClass().getName()).info("Job "+entity.getName()+" was changed to "+name);
        }
        else{
            AppContext.getMyLogger(this.getClass().getName()).warning("error during changing "+entity.getName()+" number of arguments is different from  expected!");
        }
    }


    public static void remove(Job entity) {
        System.out.println("may be in future ... ;))");
//        AppContext.getMyLogger(this.getClass().getName()).info("Job "+entity.getName()+" was removed");

    }

    @Override
    public boolean isExist(String name) {
        HashMap<Integer, Job> entityHashMap = AppContext.getJobDataBase().getEntityHashMap();
        return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue().getName())
                .toList()
                .contains(name);
    }


    @Override
    public List<Job> findAll(boolean showDeprecated) {
        HashMap<Integer, Job> entityHashMap = AppContext.getJobDataBase().getEntityHashMap();
        if (showDeprecated)
            return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
        else
            return entityHashMap.entrySet()
                    .stream()
                    .map(e -> e.getValue())
                    .toList();

    }

    @Override
    public Job getById(int id) {
        HashMap<Integer, Job> entityHashMap = AppContext.getJobDataBase().getEntityHashMap();
        return entityHashMap.get(id);
    }

    @Override
    public Job getByName(String name) {
        HashMap<Integer, Job> entityHashMap = AppContext.getJobDataBase().getEntityHashMap();
        return entityHashMap.entrySet()
                .stream()
                .filter(v-> v.getValue().getName().equals(name))
                .map(e -> e.getValue())
                .findFirst()
                .get();
    }
}
