package org.dng.EmployeeAccountingService.repository;


import org.dng.EmployeeAccountingService.Entities.Employee;


public class EmployeeDataBase extends DataBaseAbstract<Employee>{
//    private static int maxId;
//
//    private static HashMap<String, Employee> employeeHashMap = new HashMap<>();
//
//    public static int getMaxId() {
//        return maxId;
//    }
//
//    public static void setMaxId(int maxId) {
//        EmployeeDataBase.maxId = maxId;
//    }

//    public static HashMap<String, Employee> getEmployeeHashMap() {
//        return employeeHashMap;
//    }

    //    public static void add(Employee employee) throws DataBaseAddException {
    public void put(Employee entity) {
        if (entityHashMap.containsKey(entity.getInn())) {
            System.out.println("job with such INN is already present!");
            return;
        }
        entityHashMap.put(entity.getInn(), entity);
    }

}
