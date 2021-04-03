package ru.job4j.solid;

import java.util.Date;

public class Food {

    private String name;
    private Date expiryDate;
    private Date createDate;
    private int price;
    private int discount;

    public Food(String name, Date expiryDate, Date createDate, int price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public final int getPercentageOfDelay() {

        long diffInMillis = getExpiryDate().getTime() - getCreateDate().getTime();
        float deltaExpirationDateAndCreateDate = (diffInMillis / (24f * 60f * 60f * 1000f));

        diffInMillis = new Date().getTime() - getCreateDate().getTime();
        float deltaCurrentDateAndExpirationDate = (diffInMillis / (24f * 60f * 60f * 1000f));

        float result = (deltaCurrentDateAndExpirationDate / deltaExpirationDateAndCreateDate) * 100;

        return (int) result;

    }

    public final void sort(Warehouse warehouse, Shop shop, Trash trash) {

        int percentageOfDelay = getPercentageOfDelay();
        if (percentageOfDelay < 25) {
            warehouse.addToFoodList(this);
        } else if (percentageOfDelay < 75) {
            shop.addToFoodList(this);
        } else if (percentageOfDelay < 100) {
            price = (price / 100) * discount;
            shop.addToFoodList(this);
        } else {
            trash.addToFoodList(this);
        }
    }

}
