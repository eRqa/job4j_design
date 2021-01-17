package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUsage {

    public static void main(String[] args) {

        String[] golfOptions = new String[] {"Doors", "Sits", "Parking assistant",
                "MultiFunction steering wheel"};
        Car volkswagen = new Car(190, false,
                "Golf", new Engine(4), golfOptions);

        Gson gson = new GsonBuilder().create();
        String gsonVolkswagen = gson.toJson(volkswagen);
        System.out.println(gsonVolkswagen);

        Car carFromGson = gson.fromJson(gsonVolkswagen, Car.class);
        System.out.println(carFromGson);

    }

}
