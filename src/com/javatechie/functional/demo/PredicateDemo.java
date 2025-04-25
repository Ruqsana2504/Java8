package src.com.javatechie.functional.demo;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> p = (t) -> t % 2 == 0;
        System.out.println(p.test(3));

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        list1.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println("Print even numbers : " + t));
    }
}
