package org.dng.EmployeeAccountingService.Service;

import java.util.List;

public abstract class ServiceAbstract<T> {

    public abstract boolean isExist(String name);

    public abstract void add(String name);

    public abstract void change(T entity, Object... args);

    public abstract List<T> findAll();

    public abstract T getById(int id);

    public abstract T getByName(String name);
}
