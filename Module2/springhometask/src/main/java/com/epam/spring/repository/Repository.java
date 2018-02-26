package com.epam.spring.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    public Map<String, Object> getRepository() {
        return repository;
    }

    private Map<String, Object> repository = new HashMap<>();

    public void put(String key, Object object){
        repository.put(key, object);
    }

    public void delete(String key){
        repository.remove(key);
    }

    public Object get(String key){
        return repository.remove(key);
    }

}
