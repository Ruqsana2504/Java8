package src.com.java8practice;

import src.com.gdb.Employeee;
import src.com.javatechie.stream.map.Customer;
import src.com.javatechie.stream.map.EkartDatabase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Nov20 {

    static void main() {

        List<Employeee> employeeList = Employeee.getEmployees();
        List<Customer> customerList = EkartDatabase.getAll();

        String input = "Java is is awesome and and interesting";
        Map<String, Integer> map = Map.of("a", 6, "b", 1, "c", 7, "d", 3);
        List<Integer> numbers = List.of(9, 12, 1, 25, 4, 3, 10, 9, 1, 4, 9, 12, 25);

//        1. Filter even numbers from a list using streams
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println("1. Filter even numbers from a list using streams : " + evenNumbers);
        System.out.println();

//        2. Count word frequency in a given string
        Map<String, Long> wordFrequency = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("2. Count word frequency in a given string : " + wordFrequency);
        System.out.println();

//        3. Find first non - repeating character
        HashSet<Character> hs = new HashSet<>();
        Character nonRepeatingChar = input.chars()
                .mapToObj(ch -> (char) ch)
//                .filter(ch -> ch != ' ')
//                .filter(c -> !hs.add(c))
                .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst()
                .orElse(null);
        System.out.println("3. First non-repeating character : " + nonRepeatingChar);
        System.out.println();

//        4. Remove duplicates from a list
        List<String> distinctElements = Arrays.stream(input.split(" "))
                .distinct()
                .toList();
        System.out.println("4. Remove duplicates from a list : " + distinctElements);
        System.out.println();

//        5. Sort employees by salary using Comparator
        List<Employeee> sortedEmpSalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary))
                .toList();
        System.out.println("5. Sort employees by salary using Comparator : " + sortedEmpSalary);
        System.out.println();

//        6. Convert a list of strings to uppercase
        List<String> upperCaseString = Arrays.stream(input.split(" "))
                .map(String::toUpperCase)
                .toList();
        System.out.println("6. Convert a list of strings to uppercase : " + upperCaseString);
        System.out.println();

//       7. Sum all numbers in a list using reduce()
        int sum = numbers.stream()
//                .reduce(0, (a, b) -> a + b);
                .reduce(0, Integer::sum);
        System.out.println("7. Sum all numbers in a list using reduce() : " + sum);
        System.out.println();

//       8. Join strings into a comma-separated value
        String joinWords = Arrays.stream(input.split(" "))
                .collect(Collectors.joining(","));
        System.out.println("8. Join strings into a comma-separated value : " + joinWords);
        System.out.println();

//        9. Partition list into even/odd using Collectors.partitioningBy()
        System.out.println("9. Partition list into even/odd using Collectors.partitioningBy()");
        Map<Boolean, List<Integer>> partitionedElements = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("9.1. Even Numbers : " + partitionedElements.get(true));
        System.out.println("9.2. Odd Numbers : " + partitionedElements.get(false));
        System.out.println();

//        10. Find the second-highest number in a list
        int secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println("10. Find the second highest number in a list : " + secondHighest);
        System.out.println();

//        11. Flatten a list of lists using flatMap()
        List<String> flatMapString = customerList.stream()
//                .map(customer -> customer.getPhoneNumbers())
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .toList();
        System.out.println("11. Flatten a list of lists using flatMap() : " + flatMapString);
        System.out.println();

//        12. Count elements in each category(e.g.department → count)
        Map<String, Long> deptCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment, Collectors.counting()));
        System.out.println("12. Count elements in each category : " + deptCount);
        System.out.println();

//        13. Sort a Map by its values
        Map<String, Integer> sortedMapByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        System.out.println("13. Sort a Map by its values : " + sortedMapByValue);
        System.out.println();

//        14. Find duplicates in a list using streams
        hs.clear();
        Set<Character> duplicateSet = input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> !hs.add(ch))
                .collect(Collectors.toSet());
        System.out.println("14. Find duplicates in a list using streams : " + duplicateSet);
        System.out.println();

//        15. Write a custom collector to join strings in uppercase
        Collector<String, ?, String> upperJoiner =
                Collectors.collectingAndThen(
                        Collectors.mapping(String::toUpperCase, Collectors.joining(",")),
                        s -> s
                );
        String result = Arrays.stream(input.split(" ")).collect(upperJoiner);
        System.out.println("15. Write a custom collector to join strings in uppercase : " + result);
        System.out.println();

//        16. Find longest-string using max(Comparator.comparingInt(String::length))
        String longestString = Arrays.stream(input.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("16. Find longest string using max(Comparator.comparingInt(String::length)) : " + longestString);
        System.out.println();

    }
}
