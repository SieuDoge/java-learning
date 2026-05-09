package payment;

public class MomoPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("Thanh toán: " + amount + " VND bằng Momo");
        return true;
    }
}
