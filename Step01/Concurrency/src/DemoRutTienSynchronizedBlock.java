import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DemoRutTienSynchronizedBlock {
    static int sodu = 10000000;

    static int rut500() {
        synchronized (DemoRutTienSynchronizedBlock.class){
        sodu = sodu - 500000;

        return sodu;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 30; i > 0 ; i--) {
            int taskId = i;
            executor.submit(() -> {
                    int conLai = rut500();
            System.out.println("Đã rút 500k | Số dư còn: " + conLai);
            });
        }

        // Không nhận task mới, chờ task hiện tại xong
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        System.out.println("Số dư: " + sodu);
    }
}