package org.dng.EmployeeAccountingService.repository;

import org.dng.EmployeeAccountingService.Entities.Job;


public class JobDataBase extends DataBaseAbstract<Job>{
//    private  int maxId;
//
//    private static HashMap<Integer, Job> jobHashMap = new HashMap<>();

//    public int getMaxId() {
//        return maxId;
//    }
//
//    public void setMaxId(int maxId) {
//        JobDataBase.maxId = maxId;
//    }


//    public boolean isExist(String name){
//        return entityHashMap.entrySet()
//                .stream()
//                .map(e -> e.getValue().getName())
//                .toList()
//                .contains(name);
//    }



    public void put(Job entity) {
        //сначала проверим нет ли уже с таким id
        if (entityHashMap.containsKey(entity.getId())) {
            System.out.println("job with such Id is already present!");
            return;
        }
        entityHashMap.put(entity.getId(),entity);
    }

//    public  List<Job> findAll() {
//        return entityHashMap.entrySet()
//                .stream()
//                .map(e -> e.getValue())
//                .toList();
//    }
//
//    public Job getById(int id){
//        return entityHashMap.get(id);
//    }
//
//    public  Job getByName(String name){
//        return entityHashMap.entrySet()
//                .stream()
//                .filter(v-> v.getValue().getName().equals(name))
//                .map(e -> e.getValue())
//                .findFirst()
//                .get();
//    }

}
