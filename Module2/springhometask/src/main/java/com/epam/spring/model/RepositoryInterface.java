package com.epam.spring.model;

public interface RepositoryInterface {

    Object getById(String id);

    boolean delete(String id);

    void put(String id, Object object);

    Object get(String id);

}
