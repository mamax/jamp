package com.epam.spring.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataParser {

    public DataParser() {
    }

    public Map<String, Object> fetchUsersData() {
        Map<String, Object> storage = new HashMap<>();

        return storage;
    }

    public Map<String, Object> fetchEventsData() {
        Map<String, Object> storage = new HashMap<>();


        return storage;
    }

    public JsonNode parseJsonNode(File file) {
        try {
            return JsonHelper.getObjectMapper().readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T getWrapper(JsonNode jsonNode, Class<T> item) {
        return JsonHelper.getObjectMapper().convertValue(jsonNode, item);
    }
}
