package Seminar5_Lesson;

import java.util.HashMap;
import java.util.Map;

public class Passports {
    private Map<String, String> map = new HashMap<>();

    void add(String passNum, String lastName) {
        map.put(passNum, lastName);
    }

    String getByPassNum(String passNum) {
        return passNum + " : " + map.get(passNum);
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
