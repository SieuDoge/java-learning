package payment;

public class MomoPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        // Gọi API MoMo thực tế
        // Nếu thành công → return true
        // Nếu thất bại → return false
        System.out.println("Thanh toán tiền Momo: " + amount + " VND");
        return true;
    }
}
