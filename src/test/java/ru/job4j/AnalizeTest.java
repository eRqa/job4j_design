package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.Analize.User;
import static ru.job4j.Analize.Info;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void diff() {
        List<User> prevList = new ArrayList<>();
        prevList.add(new User(1, "User_1"));
        prevList.add(new User(2, "User_2"));
        prevList.add(new User(3, "User_3"));
        prevList.add(new User(4, "User_4"));
        prevList.add(new User(5, "User_5"));
        prevList.add(new User(6, "User_6"));
        prevList.add(new User(7, "User_7"));
        prevList.add(new User(8, "User_8"));

        List<User> newList = new ArrayList<>();
        newList.add(new User(1, "User_1"));
        newList.add(new User(2, "User_2"));
        newList.add(new User(4, "User_4"));
        newList.add(new User(5, "User_5555"));
        newList.add(new User(6, "User_6"));
        newList.add(new User(7, "User_7222"));
        newList.add(new User(8, "User_8999"));
        newList.add(new User(9, "User_9"));
        newList.add(new User(10, "User_10"));

        Analize analize = new Analize();

        Info info = analize.diff(prevList, newList);

        assertThat(info.added, is(2));
        assertThat(info.changed, is(3));
        assertThat(info.deleted, is(1));

    }
}