package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeService implements ServiceI<Employee> {

    @Override
    public void add(Object... args) {
        if (args.length == 12) {
            int inn = (int) args[1];
            HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
            if (entityHashMap.containsKey(inn)) {
                //System.out.println("Employee with such INN is already present!");
                AppContext.getMyLogger(this.getClass().getName()).warning("Exception during adding new Employee with INN="+inn);
                try {
                    throw new AddDuplicatedObjException("Employee with such INN is already present!");
                } catch (AddDuplicatedObjException e) {
                    System.out.println(e.getMessage());
                }
            }

            @NotNull String fullName = (String) args[0];
            LocalDate birthDate = (LocalDate) args[2];
            @NotNull Gender gender = (Gender) args[3];
            String phoneNumber = (String) args[4];
            Job job = (Job) args[5];
            @NotNull Department department = (Department) args[6];
//            Employee boss = (Employee) args[7];
            @NotNull LocalDate recruitDate = (LocalDate) args[7];
            LocalDate dismissDate = (LocalDate) args[8];
            @NotNull int salary = (int) args[9];
            String email = (String)  args[10];
            String pass = (String) args[11];

            try {
                new Employee(fullName, inn, birthDate, gender, phoneNumber, job, department, recruitDate, dismissDate, salary, email, pass);
            } catch (AddDuplicatedObjException e) {
                e.printStackTrace();
//                System.out.println(e.getMessage());
                AppContext.getMyLogger(this.getClass().getName()).warning("Exception during adding new Employee "+fullName+" "+e.getMessage());
            }
        }
    }

    @Override
    public void change(Employee entity, Object... args) {
        if (args.length == 12) {
            HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
            if (!entityHashMap.containsKey(entity.getInn())) {
                System.out.println("Employee with such INN is absent!");

                try {
                    throw new AddDuplicatedObjException("Employee with such INN is absent!");
                } catch (AddDuplicatedObjException e) {
                    e.printStackTrace();
//                    System.out.println(e.getMessage());
                    AppContext.getMyLogger(this.getClass().getName()).warning("Exception during changing Employee "+entity.getName()+" "+e.getMessage());
                }
            }


            @NotNull String fullName = (String) args[0];
            int inn = (int) args[1];
            LocalDate birthDate = (LocalDate) args[2];
            @NotNull Gender gender = (Gender) args[3];
            String phoneNumber = (String) args[4];
            Job job = (Job) args[5];
            @NotNull Department department = (Department) args[6];
//            Employee boss = (Employee) args[7];
            @NotNull LocalDate recruitDate = (LocalDate) args[7];
            LocalDate dismissDate = (LocalDate) args[8];
            @NotNull int salary = (int) args[9];
            String email = (String)  args[10];
            String pass = (String) args[11];

            entity.setFullName(fullName);
            entity.setInn(inn);
            entity.setBirthDate(birthDate);
            entity.setGender(gender);
            entity.setPhoneNumber(phoneNumber);
            entity.setJob(job);
            entity.setDepartment(department);
//            entity.setBoss(boss);
            entity.setRecruitDate(recruitDate);
            entity.setDismissDate(dismissDate);
            entity.setSalary(salary);
            entity.setEmail(email);
            entity.setPassword(pass);
            AppContext.getMyLogger(this.getClass().getName()).info("Employee "+entity.getName()+" was changed");
        }

    }



    public void dismissEmployee(Employee entity, LocalDate dismissDate) {
        entity.dismiss(dismissDate);
    }

    @Override
    public boolean isExist(String name) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue().getName())
                .toList()
                .contains(name);
    }


    @Override
    public Employee getByName(String fullName) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();

        return entityHashMap
                .entrySet()
                .stream()
                .filter(v-> v.getValue().getName().equals(fullName))
                .map(e -> e.getValue())
                .findFirst()
                .get();

    }

    public List<Employee> findEmployee(Department department) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getDepartment().equals(department))
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Employee> findEmployee(Employee employee) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue()!=null)
                .filter(e -> e.getValue().equals(employee))
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Employee> findEmployeeByBoss(Employee boss) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getBoss()!=null)
                .filter(e -> e.getValue().getBoss().equals(boss))
                .map(Map.Entry::getValue)
                .toList();
    }


    public List<Employee> findEmployee(Job job) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getJob().equals(job))
                .map(Map.Entry::getValue)
                .toList();
    }


    public List<Employee> findEmployee(final int minSalary, final int maxSalary) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap
                .entrySet()
                .stream()
                .filter(e -> (minSalary <= e.getValue().getSalary()) && (e.getValue().getSalary() <= maxSalary))
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Employee> findAll() {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();

        return entityHashMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
    }

    @Override
    public Employee getById(int id) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        //return entityHashMap.get(id);
        return entityHashMap
                .entrySet()
                .stream()
                .filter(v-> (v.getValue().getId()==id))
                .map(e -> e.getValue())
                .findFirst()
                .orElse(null);

    }

    public Employee getByInn(int inn) {
        HashMap<Integer, Employee> entityHashMap = AppContext.getEmployeeDataBase().getEntityHashMap();
        return entityHashMap.get(inn);
    }

}
