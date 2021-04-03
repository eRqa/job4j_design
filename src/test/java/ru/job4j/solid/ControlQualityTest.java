package ru.job4j.solid;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenControlWithSteak() {

        Food steak = new Meat("steak",
                new GregorianCalendar(2021, Calendar.JULY, 2).getTime(),
                new GregorianCalendar(2021, Calendar.MARCH, 2).getTime(),
                1500,
                50);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(List.of(steak));
        controlQuality.control(warehouse, shop, trash);

        assertThat(shop.getFoodList(), is(List.of(steak)));
    }

    @Test
    public void whenControlWithSteakAndBeer() {

        Food steak = new Meat("steak",
                new GregorianCalendar(2021, Calendar.JULY, 2).getTime(),
                new GregorianCalendar(2021, Calendar.MARCH, 2).getTime(),
                1500,
                50);

        Food beer = new Beer("BUD",
                new GregorianCalendar(2021, Calendar.MAY, 1).getTime(),
                new GregorianCalendar(2021, Calendar.APRIL, 1).getTime(),
                500,
                50);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(List.of(steak, beer));
        controlQuality.control(warehouse, shop, trash);

        assertThat(shop.getFoodList(), is(List.of(steak)));
        assertThat(warehouse.getFoodList(), is(List.of(beer)));
    }

    @Test
    public void whenControlWithManyFood() {

        Food steak = new Meat("steak",
                new GregorianCalendar(2021, Calendar.JULY, 2).getTime(),
                new GregorianCalendar(2021, Calendar.MARCH, 2).getTime(),
                1500,
                50);

        Food nuggets = new Meat("nuggets",
                new GregorianCalendar(2021, Calendar.APRIL, 5).getTime(),
                new GregorianCalendar(2021, Calendar.MARCH, 3).getTime(),
                1500,
                50);

        Food beerBud = new Beer("BUD",
                new GregorianCalendar(2021, Calendar.MAY, 1).getTime(),
                new GregorianCalendar(2021, Calendar.APRIL, 1).getTime(),
                500,
                50);

        Food beerBaltika = new Beer("Baltika",
                new GregorianCalendar(2021, Calendar.APRIL, 2).getTime(),
                new GregorianCalendar(2021, Calendar.APRIL, 1).getTime(),
                500,
                50);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(List.of(steak, beerBud, beerBaltika, nuggets));
        controlQuality.control(warehouse, shop, trash);

        assertThat(nuggets.getPrice(), is(750));
        assertThat(shop.getFoodList(), is(List.of(steak, nuggets)));
        assertThat(warehouse.getFoodList(), is(List.of(beerBud)));
        assertThat(trash.getFoodList(), is(List.of(beerBaltika)));
    }
}