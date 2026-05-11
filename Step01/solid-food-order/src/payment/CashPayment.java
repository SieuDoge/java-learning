package payment;

public class CashPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.println("Thanh toán tiền mặt: " + amount + " VND");
        return true; // Tiền mặt luôn thành công
    }
}