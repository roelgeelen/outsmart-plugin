package com.differentdoors.outsmart.models;
import java.util.HashMap;
import java.util.Map;

public abstract class Employees {
    private static Map<String, String> employees = new HashMap<>() {
        {
            put("1", "Thomas");
            put("6", "Max");
            put("9", "Pascal");
            put("10", "Jay");
            put("11", "Bart");
            put("15", "Mathijs");
            put("71850", "Steve");
            put("71853", "Patrick");
            put("71851", "Remco");
            put("73710", "Lars");
            put("74368", "Teun");
            put("89356", "Luuk");
            put("83298", "Jelle");
            put("89358", "Ruud");
            put("89362", "Martien");
            put("89364", "Wesley");
            put("89367", "Danny");
            put("89368", "Sem");
            put("89370", "Wilco");
            put("89371", "Davie");
        }
    };

    public static String getEmployee(String id) {
        return employees.get(id);
    }
}
