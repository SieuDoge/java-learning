import java.util.concurrent.CompletableFuture;


public class Practice {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> bookingTicket = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Đang tìm chuyến bay...");
                    sleep(1000);
                    return "VN123 HCM→HAN";
                })
                .thenApply(found -> {
                    System.out.println("Đặt ghế cho chuyến: " + found);
                    sleep(1000);
                    return found.split(" ")[0] + " — Ghế 12A";
                })
                .thenAccept(seatInfo -> {
                    System.out.println("Đặt vé thành công: " + seatInfo + " — 2,500,000đ");
                    sleep(500);
                });

        System.out.println("Đang xử lý đơn đặt vé...");
        bookingTicket.join();
        System.out.println("bookingTicket xong!");
    }
    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
