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
        Calendar calendarVasilev = new GregorianCalendar(2017, 0, 25);
        User user1 = new User("Vasilev", 1, calendarVasilev);
        User user2 = new User("Vasilev", 1, calendarVasilev);

        Map<User, Object> hashMap = new HashMap<>();
        hashMap.put(user1, "Vasilev");
        hashMap.put(user2, "Vasilev");

        System.out.println(hashMap.toString());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
