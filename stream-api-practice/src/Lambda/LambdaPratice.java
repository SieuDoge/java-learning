package Lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaPratice {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> even = n -> n % 2 == 0;
        numbers.forEach(chan -> System.out.println(even.test(chan)));

        Function<Integer, String> f = x -> "Số: " + x;
        numbers.forEach(item -> System.out.println(f.apply(item)));



    }
}


