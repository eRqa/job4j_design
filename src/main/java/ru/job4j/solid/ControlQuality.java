package ru.job4j.solid;

import java.util.Date;
import java.util.List;

public class ControlQuality {

    private List<Food> foodToControlList;

    public ControlQuality(List<Food> foodToControlList) {
        this.foodToControlList = foodToControlList;
    }

    public void control(Warehouse warehouse, Shop shop, Trash trash) {
        for (Food food
                : foodToControlList) {
            food.sort(warehouse, shop, trash);
        }
    }

}
