package org.dng.EmployeeAccountingService.Service;


import java.util.List;

//public abstract class ServiceAbstract<T> {
interface ServiceI<T> {

    public abstract boolean isExist(String name);

    public abstract void add(Object... args);

//    public abstract void add(String name);

//    public abstract void add(@NotNull String fullName,
//                             int inn,
//                             LocalDate birthDate,
//                             @NotNull
//                                     Gender gender,
//                             String phoneNumber,
//                             Job job,
//                             @NotNull Department department,
//                             Employee boss,
//                             @NotNull LocalDate recruitDate,
//                             LocalDate dismissDate,
//                             @NotNull int salary);

    public abstract void change(T entity, Object... args);

    public abstract List<T> findAll();

    public abstract T getById(int id);

    public abstract T getByName(String name);
}
