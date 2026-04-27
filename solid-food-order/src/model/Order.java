package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<MenuItem> items;
    public Order(String id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    // Getter
    public String getId() { return id; }
    public List<MenuItem> getItems() { return items; }
}