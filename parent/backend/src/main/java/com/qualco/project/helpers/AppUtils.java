package com.qualco.project.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AppUtils {

    public static <T> Object objectDecoder(String value, Class<T> objectClass) throws JsonProcessingException {
        byte[] asBytes = Base64.getDecoder().decode(value);
        ObjectMapper objectMapper = new ObjectMapper();
        String decodeSort = new String(asBytes, StandardCharsets.UTF_8);
        return objectMapper.readValue(decodeSort, objectClass);
    }
}
