package org.dng.EmployeeAccountingService.repository;

import java.util.HashMap;

public abstract class DataBaseAbstract<T> {
    protected int maxId;

    protected HashMap<Integer, T> entityHashMap = new HashMap<>();

    public int getMaxId() {
        return maxId;
    }

//    public void setMaxId(int maxId2) {
//        maxId = maxId2;
//    }

    public HashMap<Integer, T> getEntityHashMap() {
        return entityHashMap;
    }
}
