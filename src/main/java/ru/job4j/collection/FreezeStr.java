package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {

        char[] leftCharArray = left.toCharArray();
        char[] rightCharArray = right.toCharArray();
        Map<Character, Integer> leftMap = new HashMap<>();

        for (char c
                : leftCharArray) {
            leftMap.putIfAbsent(c, 0);
            leftMap.compute(c, (key, value) -> ++value);
        }

        for (char c
                : rightCharArray) {
            if (leftMap.containsKey(c)) {
                Integer intValue = leftMap.get(c);
                leftMap.put(c, --intValue);
                if (intValue == 0) {
                    leftMap.remove(c);
                }
            } else {
                break;
            }
        }

        return leftMap.size() == 0;
    }

}