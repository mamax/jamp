package com.epam.spring.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    public Map<Long, Object> getRepository() {
        return repository;
    }

    Map<Long, Object> repository = new HashMap<>();

    public void put(Long key, Object object){
        repository.put(key, object);
    }

    public void delete(Long key){
        repository.remove(key);
    }

    public Object get(Long key){
        return repository.remove(key);
    }

}
