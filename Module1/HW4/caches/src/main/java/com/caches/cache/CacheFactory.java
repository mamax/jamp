package com.caches.cache;

import com.caches.dao.CrudDao;

public class CacheFactory {

    public <KEY, VAL> Cache<KEY, VAL> createEntityCache(int maxSize, CrudDao<KEY, VAL> systemOfRecord) {
        return new ListFirstUsedCache<KEY, VAL>(maxSize, systemOfRecord);
    }

}
