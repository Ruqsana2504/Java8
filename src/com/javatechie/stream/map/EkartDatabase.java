package src.com.javatechie.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDatabase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("3876343423", "21346576")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("5676343423", "34346576")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("7876343423", "98346576")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("3890343423", "94866576"))
        ).collect(Collectors.toList());
    }
}
