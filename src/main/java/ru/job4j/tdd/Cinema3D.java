package ru.job4j.tdd;

import ru.job4j.tdd.interfaces.Account;
import ru.job4j.tdd.interfaces.Cinema;
import ru.job4j.tdd.interfaces.Session;
import ru.job4j.tdd.interfaces.Ticket;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
