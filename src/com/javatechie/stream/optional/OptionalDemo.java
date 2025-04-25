package src.com.javatechie.stream.optional;

import src.com.javatechie.stream.map.Customer;
import src.com.javatechie.stream.map.EkartDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) {
        List<Customer> customers = EkartDatabase.getAll();
        return customers.stream().filter(c -> c.getEmail().equals(email)).findAny().orElseThrow(() -> new RuntimeException("No customer present with this emailId"));
    }

    public static void main(String[] args) {
        Customer customer = new Customer(101, "John", null, Arrays.asList("3876343423", "21346576"));

        //empty
        //of --> when you know value passed is always not empty
        //Nullable
        Optional<Object> emptyOptional = Optional.empty();
//        System.out.println(emptyOptional);

//        Optional<String> emailOptional = Optional.of(customer.getName());
//        System.out.println(emptyOptional);

        Optional<String> id = Optional.ofNullable(customer.getEmail());
//        id.ifPresent(System.out::println);
//        System.out.println(id.orElse("default@gmail.com"));
//        System.out.println(id.orElseThrow(() -> new IllegalArgumentException("Email not present")));

//        System.out.println(id.map(String::toUpperCase).orElseGet(() -> "default email..."));

        System.out.println(getCustomerByEmailId("pqr"));
    }
}
