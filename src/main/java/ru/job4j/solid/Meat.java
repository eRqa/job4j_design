package ru.job4j.solid;

import java.util.Date;

public class Meat extends Food {

    public Meat(String name, Date expiryDate, Date createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Date getExpiryDate() {
        return super.getExpiryDate();
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        super.setExpiryDate(expiryDate);
    }

    @Override
    public Date getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public void setCreateDate(Date createDate) {
        super.setCreateDate(createDate);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public int getDiscount() {
        return super.getDiscount();
    }

    @Override
    public void setDiscount(int discount) {
        super.setDiscount(discount);
    }
}
