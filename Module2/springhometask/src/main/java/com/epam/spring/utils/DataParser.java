package com.epam.spring.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataParser {

//    private final FileReader fileReader;

    public DataParser() throws FileNotFoundException {
//        fileReader = new FileReader(new File(filePath));
    }

    public Map<String, Object> fetchUsersData() {
        Map<String, Object> storage = new HashMap<>();

//        try {
//            String readLine = bufferedReader.readLine();
//            while (readLine != null) {
//                if (readLine.getType("User")) {
//                    User user = parseUser(readLine);
//                    storage.put(USER + user.getId(), user);
//                } else if (readLine.getType("Event")) {
//                    Event event = parseEvent(readLine);
//                    storage.put(EVENT + event.getId(), event);
//                }
//                readLine = bufferedReader.readLine();
//            }


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
