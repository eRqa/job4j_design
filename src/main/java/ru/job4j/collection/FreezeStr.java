package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {

        boolean rsl = false;

        char[] leftCharArray = left.toCharArray();
        char[] rightCharArray = right.toCharArray();
        Map<Character, Integer> leftMap = new HashMap<>();

        for (char c
                : leftCharArray) {
            if (leftMap.containsKey(c)) {
                Integer intValue = leftMap.get(c);
                leftMap.put(c, ++intValue);
            } else {
                leftMap.put(c, 1);
            }
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