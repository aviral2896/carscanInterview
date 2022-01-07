package com.example.carscaninterview.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class CustomUtil {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static Thread background(Runnable r) {
        final Thread t = new Thread(r);
        t.start();
        return t;
    }

    public static String randomColor() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        return String.format("#%06x", rand_num);
    }

    public static boolean empty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean empty(Object o) {
        if (o == null) return true;
        if (o instanceof String) return o.toString().length() == 0;
        if (o instanceof Collection) return ((Collection) o).isEmpty();
        if (o instanceof Map) return ((Map) o).isEmpty();
        if (o instanceof JsonNode) {
            if (o instanceof ObjectNode) return ((ObjectNode) o).size() == 0;
            if (o instanceof ArrayNode) return ((ArrayNode) o).size() == 0;
            final String json = ((JsonNode) o).textValue();
            return json == null || json.length() == 0;
        }
        if (o instanceof Iterable) return !((Iterable) o).iterator().hasNext();
        if (o.getClass().isArray()) {
            if (o.getClass().getComponentType().isPrimitive()) {
                switch (o.getClass().getComponentType().getName()) {
                    case "boolean":
                        return ((boolean[]) o).length == 0;
                    case "byte":
                        return ((byte[]) o).length == 0;
                    case "short":
                        return ((short[]) o).length == 0;
                    case "char":
                        return ((char[]) o).length == 0;
                    case "int":
                        return ((int[]) o).length == 0;
                    case "long":
                        return ((long[]) o).length == 0;
                    case "float":
                        return ((float[]) o).length == 0;
                    case "double":
                        return ((double[]) o).length == 0;
                    default:
                        return o.toString().length() == 0;
                }
            } else {
                return ((Object[]) o).length == 0;
            }
        }
        return o.toString().length() == 0;
    }

}