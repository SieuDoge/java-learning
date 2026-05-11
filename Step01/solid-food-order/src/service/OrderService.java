package service;

import model.Order;
import payment.PaymentMethod;
import repository.OrderRepository;

public class OrderService {
    private final OrderRepository repository;
    private final PaymentMethod payment;

    public OrderService(OrderRepository repository, PaymentMethod payment) {
        this.repository = repository;
        this.payment = payment;
    }

    public void placeOrder(Order order) {
        repository.save(order);
        boolean success = payment.pay(order.getTotalPrice());
        if (success) {
            System.out.println("Đặt hàng thành công: " + order.getId());
        } else {
            System.out.println("Thanh toán thất bại: " + order.getId());
        }
    }
}
