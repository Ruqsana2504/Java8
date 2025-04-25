package src.com.javatechie.functional.demo;

import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> 7;
        System.out.println(s.get());

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        System.out.println(list1.stream().findAny().orElseGet(() -> 0));

    }
}
