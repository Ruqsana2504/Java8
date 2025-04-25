package src.com.javatechie.functional.demo;

import java.util.List;

public class ConsumerDemo {

    public static void main(String[] args) {
//        Consumer<Integer> c = t -> System.out.println(t);
//        c.accept(10);

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        list1.stream().forEach(t -> System.out.println(t));
    }
}
