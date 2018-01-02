package com.caches.cache;

import com.caches.dao.CrudDao;

import java.util.LinkedHashMap;
import java.util.Map;

public class ListFirstUsedCache<KEY, VAL> implements Cache<KEY, VAL> {

    private final int cacheMaxSize;
    private final CrudDao<KEY, VAL> systemOfRecord;
    private LinkedHashMap<KEY, CacheEntry> cacheStorageMap = new LinkedHashMap<KEY, CacheEntry>();

    public ListFirstUsedCache(int cacheMaxSize, CrudDao<KEY, VAL> systemOfRecord) {
        this.cacheMaxSize = cacheMaxSize;
        this.systemOfRecord = systemOfRecord;
    }

    private class CacheEntry {
        private final VAL data;
        private int frequency;

        public CacheEntry(VAL data) {
            this.data = data;
            this.frequency = 0;
        }
    }

    public VAL get(KEY key) {
        if (cacheStorageMap.containsKey(key)) {
            CacheEntry tempFromCache = cacheStorageMap.get(key);
            tempFromCache.frequency++;
            return tempFromCache.data;
        } else {
            VAL val = systemOfRecord.read(key);
            CacheEntry tempFromSOR = new CacheEntry(val);
            cacheStorageMap.put(key, tempFromSOR);
            return val;
        }
    }

    public void put(KEY key, VAL value) {
        if (!isCacheMapFull()) {
            CacheEntry temp = new CacheEntry(value);
            cacheStorageMap.put(key, temp);
        } else {
            KEY entryKeyToRemove = getListFirstUsedKey();
            cacheStorageMap.remove(entryKeyToRemove);
            CacheEntry temp = new CacheEntry(value);
            cacheStorageMap.put(key, temp);
        }

        WriteBehind writeBehind = new WriteBehind(key, value);
        writeBehind.start();
    }

    private KEY getListFirstUsedKey() {
        KEY key = null;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<KEY, CacheEntry> entry : cacheStorageMap.entrySet()) {
            if (minFreq > entry.getValue().frequency) {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    private boolean isCacheMapFull() {
        return getSize() >= cacheMaxSize;
    }

    private int getSize(){
        return cacheStorageMap.size();
    }

    private class WriteBehind extends Thread{
        private static final long WRITE_DELAY = 3000;
        private final KEY key;
        private final VAL val;

        public WriteBehind(KEY key, VAL val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(WRITE_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (systemOfRecord.read(key) == null) {
                systemOfRecord.create(val);
            } else {
                systemOfRecord.update(val);
            }
        }
    }
}
