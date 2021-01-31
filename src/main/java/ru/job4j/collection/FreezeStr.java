package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = false;

        Set<Character> leftSet = stringToSet(left);
        Set<Character> rightSet = stringToSet(right);

        return leftSet.containsAll(rightSet);
    }

    private static Set<Character> stringToSet(String str) {
        Set<Character> set = new HashSet<>();
        char[] charArray = str.toCharArray();

        for (char c
                : charArray) {
            set.add(c);
        }

        return set;

    }

}