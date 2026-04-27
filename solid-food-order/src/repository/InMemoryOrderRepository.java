package repository;

import model.MenuItem;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {
    public List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }
    @Override
    public Order findById(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }
}
