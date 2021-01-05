package ru.job4j.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendarVasilev = new GregorianCalendar(2017, 0 , 25);
        Calendar calendarPetrov = new GregorianCalendar(2015, 0 , 25);
        User Vasilev = new User("Vasilev", 1, calendarVasilev);
        User Petrov = new User("Petrov", 4, calendarPetrov);

        Map<User, Object> hashMap = new HashMap<>();
        hashMap.put(Vasilev, "Vasilev");
        hashMap.put(Petrov, "Petrov");

        System.out.println(hashMap.toString());

    }

}
