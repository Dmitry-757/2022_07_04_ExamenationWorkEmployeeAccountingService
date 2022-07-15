package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Job;

import java.util.HashMap;
import java.util.List;

public class JobService extends ServiceAbstract<Job>{

    @Override
    public void add(String name) {
        try {
            new Job(name);
        } catch (AddDuplicatedObjException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void change(Job entity, Object ... args) {
        if (args.length==1){
            String name = (String) args[0];
            entity.setName(name);
        }
    }


    public static void remove(Job job) {
        System.out.println("may be in future ... ;))");
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
    public List<Job> findAll() {
        HashMap<Integer, Job> entityHashMap = AppContext.getJobDataBase().getEntityHashMap();
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
