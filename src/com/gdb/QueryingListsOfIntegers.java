package src.com.gdb;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueryingListsOfIntegers {

    public static void main(String[] args) {
        List<Integer> list2 = Arrays.asList(35, 45, 23, 39, 2, 3, 1, 5, 4, 7, 6, 9, 8, 11, 10, 13, 12, 15, 14, 11, 9, 23, 76, 93, 11, 5, 12, 99, 52);
        List<Integer> list1 = new ArrayList<>(list2);
        list1.add(7);

        //1. max, min , count, sum, prod
        int max = list1.stream().max(Integer::compare).get();
        System.out.println("1.a.Max element in the list : " + max);
        int min = list1.stream().min(Integer::compare).get();
        System.out.println("1.b.Min element in the list : " + min);
        long count = list1.stream().count();
        System.out.println("1.c.Count of elements in the list : " + count);
        int sum = list1.stream().reduce(0, Integer::sum);
        System.out.println("1.d.Sum of elements in the list : " + sum);
        int prod = list1.stream().reduce(1, (a, b) -> a * b);
        System.out.println("1.e.Product of elements in the list : " + prod);
        System.out.println();

        //2. Even, odd
        List<Integer> evenNumbers = list1.stream().filter(num -> num % 2 == 0).toList();
        System.out.println("2.a.Even numbers in the list : " + evenNumbers);
        List<Integer> oddNumbers = list1.stream().filter(num -> num % 2 != 0).toList();
        System.out.println("2.b.Odd numbers in the list : " + oddNumbers);
        System.out.println();

        //3. sorting
        List<Integer> sortedNumbers = list1.stream().sorted().toList();
        System.out.println("3.a.Sorted numbers in ascending order in the list : " + sortedNumbers);
        List<Integer> sortedNumbersDescending = list1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("3.b.Sorted numbers in descending order in the list : " + sortedNumbersDescending);
        System.out.println();

        //4. findFirst and find last map, filter, reduce
        System.out.println("4.a.fetching first element of the list in the cubes of number less than 10: " + list1.stream().map(i -> i * i * i).filter(i -> i < 10).findFirst().get());
        System.out.println("4.b.fetching any element of the list in the squares of number greater-than 2000: " + list1.stream().map(i -> i * i).filter(i -> i > 3000).findAny().get());
        System.out.println("4.c.finding last element of the list in the range of 51-99: " + list1.stream().filter(i -> i > 50 && i < 99).reduce((_, second) -> second).orElse(-1));
        System.out.println();

        //5. count the occurrence of each element, find duplicates and remove duplicates
        Map<Integer, Long> occurrenceCounter = list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("5.a.Occurrence of integers in the list : " + occurrenceCounter);
        ArrayList<Integer> duplicateList = new ArrayList<>();
        list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> {
            if (v > 1)
                duplicateList.add(k);
        });
        System.out.println("5.b.Duplicate elements in the list : " + duplicateList);
        List<Integer> distintList = list1.stream().distinct().toList();
        System.out.println("5.c.List after removing duplicates : " + distintList);
        System.out.println();

        //6. starts with, ends with
        List<String> numbersStartingWith1 = list1.stream().map(num -> num + "").filter(num -> num.startsWith("1")).toList();
        System.out.println("6.a.Numbers starting with 1 : " + numbersStartingWith1);
        List<String> numbersEndingWith5 = list1.stream().map(num -> num + "").filter(num -> num.endsWith("5")).toList();
        System.out.println("6.b.Numbers ending with 5 : " + numbersEndingWith5);
    }
}
