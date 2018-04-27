package com.epam.spring.repository;

import com.epam.spring.model.RepositoryInterface;

import java.util.HashMap;
import java.util.Map;

public class Repository implements RepositoryInterface{

    public Object getById(String id) {
        return repository.get(id);
    }

    public Map<String, Object> getRepository() {
        return repository;
    }

    private Map<String, Object> repository = new HashMap<>();

    public void put(String key, Object object){
        repository.put(key, object);
    }

    public boolean delete(String key){
        return repository.remove(key) != null;
    }

    public Object get(String key){
        return repository.get(key);
    }

}
