package org.dng.EmployeeAccountingService.repository;

import java.util.HashMap;
import java.util.List;

public abstract class DataBaseAbstract<T> {
    protected int maxId;

    protected HashMap<Integer, T> entityHashMap = new HashMap<>();

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId2) {
        maxId = maxId2;
    }


    public abstract boolean isExist(String name);

    public abstract void add(T entity);

    public abstract List<T> findAll();

    public abstract T getById(int id);

    public abstract T getByName(String name);

}
