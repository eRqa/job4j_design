package ru.job4j.solid;

import java.util.ArrayList;
import java.util.List;

public class Trash {

    private final List<Food> foodList = new ArrayList<>();

    public List<Food> getFoodList() {
        return foodList;
    }

    public void addToFoodList(Food food) {
        foodList.add(food);
    }
}
