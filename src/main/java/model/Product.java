package model;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private String type;
    private int price;
    private Date date_buy;
    private User user;

    public Product() {
    }

    public Product(int id, String name, String type, int price, Date date_buy, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.date_buy = date_buy;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate_buy() {
        return date_buy;
    }

    public void setDate_buy(Date date_buy) {
        this.date_buy = date_buy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", date_buy=" + date_buy +
                '}';
    }
}
