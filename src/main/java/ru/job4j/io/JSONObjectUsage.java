package ru.job4j.io;

import org.json.JSONObject;

public class JSONObjectUsage {
    public static void main(String[] args) {

        String[] golfOptions = new String[] {"Doors", "Sits", "Parking assistant",
                "MultiFunction steering wheel"};
        Car volkswagen = new Car(190, false,
                "Golf", new Engine(4), golfOptions);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("power", volkswagen.getPower());
        jsonObject.put("isConvertible", volkswagen.isConvertible());
        jsonObject.put("model", volkswagen.getModel());
        jsonObject.put("engine", new JSONObject(volkswagen.getEngine()));
        jsonObject.put("options", volkswagen.getOptions());

        System.out.println(jsonObject.toString());
    }
}
