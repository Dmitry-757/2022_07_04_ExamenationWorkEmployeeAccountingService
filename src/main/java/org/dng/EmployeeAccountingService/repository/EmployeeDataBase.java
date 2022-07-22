package org.dng.EmployeeAccountingService.repository;


import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.AddDuplicatedObjException;
import org.dng.EmployeeAccountingService.Entities.Employee;
import java.io.Serializable;





public class EmployeeDataBase extends DataBaseAbstract<Employee> implements Serializable {
//public class EmployeeDataBase implements Serializable {
    private static final long serialVersionUID = 3L;


    //    public static void add(Employee employee) throws DataBaseAddException {
    public void put(Employee entity) throws AddDuplicatedObjException {
        if (entityHashMap.containsKey(entity.getInn())) {
            System.out.println("Employee with such INN is already present!");
            throw new AddDuplicatedObjException("Employee with such INN is already present!");
        }
        entityHashMap.put(entity.getInn(), entity);
        AppContext.getMyLogger(this.getClass().getName()).info("Employee "+entity.getName()+" was put to HashMap");
    }

}
