package org.dng.EmployeeAccountingService.repository;

import java.io.Serializable;
import java.util.HashMap;

public abstract class DataBaseAbstract<T> implements Serializable {
    private static final long serialVersionUID = 5L;

    protected int maxId;

    protected HashMap<Integer, T> entityHashMap = new HashMap<>();

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int id) {
        this.maxId = id;
    }

    public HashMap<Integer, T> getEntityHashMap() {
        return entityHashMap;
    }
}
