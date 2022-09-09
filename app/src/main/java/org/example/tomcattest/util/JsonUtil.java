package org.example.tomcattest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

public class JsonUtil {

    private final ObjectMapper objectMapper;

    public JsonUtil(@NonNull final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String convertObjectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Error converting to json", ex);
        }
    }

    public <T> T convertJsonToObject(String json, Class<T> classReference) {
        try {
            return objectMapper.readValue(json, classReference);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Error converting from json", ex);
        }
    }

}
