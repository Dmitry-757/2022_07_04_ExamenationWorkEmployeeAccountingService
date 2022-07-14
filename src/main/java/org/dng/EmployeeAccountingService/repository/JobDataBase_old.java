package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Job;

import java.util.HashMap;
import java.util.List;

public class JobDataBase_old {
    private static int maxId;

    private static HashMap<Integer, Job> jobHashMap = new HashMap<>();

    public static int getMaxId() {
        return maxId;
    }

    public static void setMaxId(int maxId) {
        JobDataBase_old.maxId = maxId;
    }

    public static HashMap<Integer, Job> getJobHashMap() {
        return jobHashMap;
    }

    public static boolean isExist(String name){
        return jobHashMap.entrySet()
                .stream()
                .map(e -> e.getValue().getName())
                .toList()
                .contains(name);
    }

    //    public static void add(Employee employee) throws DataBaseAddException {
    public static void add(Job job) {
        //сначала проверим нет ли уже с таким id
        if (jobHashMap.containsKey(job.getId())) {
            System.out.println("job with such Id is already present!");
            return;
        }
        jobHashMap.put(job.getId(),job);
    }

    public static List<Job> findAll() {
        return jobHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
    }

    public static Job getById(int id){
        return jobHashMap.get(id);
    }

    public static Job getByName(String name){
        return jobHashMap.entrySet()
                .stream()
                .filter(v-> v.getValue().getName().equals(name))
                .map(e -> e.getValue())
                .findFirst()
                .get();
    }

}
