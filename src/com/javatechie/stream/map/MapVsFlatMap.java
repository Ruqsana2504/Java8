package src.com.javatechie.stream.map;

import java.util.List;

public class MapVsFlatMap {

    public static void main(String[] args) {
        List<Customer> customerList = EkartDatabase.getAll();

        //List<Customer> to List<String> -> Data Transformation
        List<String> phones = customerList.stream()
                .map(Customer::getEmail)
                .toList();
        System.out.println(phones);

        //Customer -> Customer.getPhoneNumbers --> One to many mapping
        List<List<String>> phoneNumbers = customerList.stream()
                .map(Customer::getPhoneNumbers)
                .toList();
        System.out.println(phoneNumbers);

        List<String> phoneNumbersFlatMap = customerList.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .toList();
        System.out.println(phoneNumbersFlatMap);

    }
}
