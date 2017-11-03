package com.epam.spring.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    public Map<Long, Object> getStorage() {
        return storage;
    }

    Map<Long, Object> storage = new HashMap();

    public void put(Long key, Object object){
        storage.put(key, object);
    }

    public Object get(long id) {
        return storage.get(id);
    }

    public void delete(long eventId) {
        storage.remove(eventId);
    }
}
