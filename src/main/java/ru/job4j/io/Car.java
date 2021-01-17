package ru.job4j.io;

public class Car {

    private int power;
    private boolean isConvertible;
    private String model;
    private Engine engine;
    private String[] options;

    public Car(int power, boolean isConvertible, String model, Engine engine, String[] options) {
        this.power = power;
        this.isConvertible = isConvertible;
        this.model = model;
        this.engine = engine;
        this.options = options;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
