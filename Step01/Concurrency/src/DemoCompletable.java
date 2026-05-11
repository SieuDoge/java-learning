import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class DemoCompletable {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> giaVang = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Vàng: 85 triệu/lượng";
        });

        CompletableFuture<String> giaDola = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Đô: 25,000đ/USD";
        });

// Chờ cả 2 xong rồi gộp — tổng thời gian = 1.5 giây, không phải 2.5 giây
        CompletableFuture<String> combined = giaVang.thenCombine(giaDola,
                (vang, dola) -> vang + " | " + dola
        );

        System.out.println(combined.join());
// Output: Vàng: 85 triệu/lượng | Đô: 25,000đ/USD}
    }
}
