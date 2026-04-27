import model.MenuItem;
import model.Order;
import payment.CashPayment;
import payment.PaymentMethod;
import repository.InMemoryOrderRepository;
import repository.OrderRepository;
import service.OrderService;

public class Main {
    public static void main(String[] args) {

        MenuItem item1 = new MenuItem("Cơm Gà", 35000, "Thức ăn");
        MenuItem item2 = new MenuItem("Cơm Chiên", 35000, "Thức ăn");

        Order order1 = new Order("1");
        Order order2 = new Order("2");
        Order order3 = new Order("3");

        order1.addItem(item1);
        order2.addItem(item2);
        order3.addItem(item1);
        order3.addItem(item2);


        OrderRepository repository = new InMemoryOrderRepository();
        PaymentMethod payment = new CashPayment();

        OrderService orderService = new OrderService(repository, payment);

        orderService.placeOrder(order1);
        orderService.placeOrder(order2);
        orderService.placeOrder(order3);
    }
}