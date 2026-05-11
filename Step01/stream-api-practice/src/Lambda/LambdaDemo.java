package Lambda;

import java.util.*;
import java.util.function.*;

public class LambdaDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "An", "Bảo");

        // Predicate — kiểm tra tên dài hơn 3 ký tự
        Predicate<String> longName = name -> name.length() > 3;
        System.out.println(longName.test("Bob"));     // false
        System.out.println(longName.test("Alice"));   // true

        // Function — chuyển tên thành chữ hoa
        Function<String, String> toUpper = name -> name.toUpperCase();
        System.out.println(toUpper.apply("alice"));   // ALICE

        // Method reference — cách viết ngắn hơn Lambda khi chỉ gọi 1 method
        Function<String, String> toUpper2 = String::toUpperCase; // tương đương dòng trên

        // Consumer — in ra
        Consumer<String> print = name -> System.out.println("Hello, " + name);
        print.accept("Bảo");   // Hello, Bảo

        // Supplier — tạo giá trị mặc định
        Supplier<String> defaultName = () -> "Unknown";
        System.out.println(defaultName.get());  // Unknown
    }
}