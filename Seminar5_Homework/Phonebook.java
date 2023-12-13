package Seminar5_Homework;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, String> map = new HashMap<>();

    void add(String phoneNum, String lastName) {
        map.put(phoneNum, lastName);
    }

    String getByPhoneNumber(String phoneNum) {
        return phoneNum + " : " + map.get(phoneNum);
    }

    String getByLastName(String lastName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var entry : map.entrySet()) {
            if (entry.getValue().equals(lastName)) {
                stringBuilder.append(entry.getKey())
                             .append(" : ")
                             .append(entry.getValue())
                             .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    String getAll() {
        return map.toString();
    }

}
