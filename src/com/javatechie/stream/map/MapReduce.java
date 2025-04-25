package src.com.javatechie.stream.map;

import src.com.javatechie.stream.api.example.Employee;
import src.com.javatechie.stream.api.example.EmployeeDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        Optional<Integer> reduce1 = numbers.stream().reduce(Integer::sum);
        System.out.println(reduce1.get());

        Integer maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxValue);

        Integer maxValueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxValueWithMethodReference);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        Optional<String> longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        System.out.println(longestString.get());

        List<Employee> employees = EmployeeDatabase.getEmployees();
        double avgSalary = employees.stream()
                .filter(employee -> employee.getDept().equalsIgnoreCase("IT"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(avgSalary);

        double sumSalary = employees.stream()
                .filter(employee -> employee.getDept().equalsIgnoreCase("IT"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .sum();
        System.out.println(sumSalary);
    }
}
