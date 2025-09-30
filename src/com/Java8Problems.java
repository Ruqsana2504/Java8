package src.com;

import src.com.gdb.Employeee;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Problems {

    public static void main(String[] args) {
        List<Employeee> employees = Employeee.getEmployees();
        String input = "Java is is awesome and and interesting";
        HashSet<Character> charHashSet = new HashSet<>();
        HashSet<String> stringHashSet = new HashSet<>();
        int[] nums = {9, 12, 1, 25, 4, 3, 10, 9, 1, 4, 9, 12, 25};
        List<Integer> numList = List.of(9, 12, 1, 25, 9, 4, 3, 10, 9, 1, 4, 9, 12, 25);
        List<String> strArrayList = Arrays.asList("Sehrish", "Unnisa", "Ruqsana", "", "Daniya", "", "Shibra", "KhuratUlAin", "madam");
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);

// 		1. Find the First Non-Repeated Character in a String
        char firstNonRepeatedChar = input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(charHashSet::add)
                .findFirst().get();

        System.out.println("1. First Non-Repeated Character in a String : " + firstNonRepeatedChar);
        System.out.println();

// 		2. Find Duplicate Elements in a List

        System.out.print("2. Duplicate Elements in a List : ");
        Arrays.stream(input.split(" "))
// 		.filter(str -> !stringHashSet.add(str))
                .filter(Predicate.not(stringHashSet::add))
                .forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        System.out.println();

// 		3. Sort a List of Employees by Salary and Name

        System.out.println("3. Sort a List of Employees by Salary and Name ");
        List<Employeee> sortedEmployeeSal = employees.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary)).toList();

        List<Employeee> sortedEmployeeSalAndName = employees.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary).thenComparing(Employeee::getName)).toList();

        //Using lambda
//        List<Employeee> sortedEmployeeSalAndNameUsingLambda = employees.stream()
//                .sorted((e1, e2) -> {
//                    int salaryCompare = Double.compare(e1.getSalary(), e2.getSalary());
//                    return salaryCompare != 0 ? salaryCompare : e1.getName().compareTo(e2.getName());
//                }).toList();

        sortedEmployeeSalAndName.forEach(emp -> System.out.println(emp.getName() + " " + emp.getSalary()));
        System.out.println();

// 		4. Count Occurrences of Each Word in a Sentence

        Map<String, Long> countOfWords = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("4. Count Occurrences of Each Word in a Sentence : " + countOfWords);
        System.out.println();

// 		5. Find the Second-Highest Number in an Array

        Arrays.sort(nums);

        System.out.println("5. Second Highest Number in an Array : " + nums[nums.length - 2]);
        System.out.println();

// 		6. Check if Two Strings are Anagrams (a word or phrase that is made by arranging the letters of another word or phrase in a different order)

        String str1 = "Fried";
        String str2 = "Fired";

        boolean isAnagram = str1.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .equals(str2.chars()
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        System.out.println("6. Two Strings are Anagrams : " + isAnagram);
        System.out.println();

// 		7. Reverse Each Word in a Sentence

        String reversedString = Arrays.stream(input.split(" "))
                .map(str -> new StringBuilder(str).reverse()).collect(Collectors.joining(" "));

        System.out.println("7. Reverse Each Word in a Sentence : " + reversedString);
        System.out.println();

// 		8. Find the Longest String in a List

        String longestString = Arrays.stream(input.split(" ")).max(Comparator.comparingInt(String::length)).get();

        System.out.println("8. Longest String in a List : " + longestString);
        System.out.println();

// 		10. Flatten a List of Lists

        List<List<String>> nestedList = List.of(List.of("Ruqsana", "Daniya"));

        List<String> finalList = nestedList.stream().flatMap(List::stream).toList();

        System.out.println("10. Flatten a List of Lists : " + nestedList + " Final List : " + finalList);
        System.out.println();

// 		11. Occurrence of each no in list of integers
// 		Map<Integer, Long> occOfNum = numList.stream()
        //.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> occOfNum = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("11. Occurrence of each no in list of integers : " + occOfNum);
        System.out.println();

// 		12. Sort the array of numbers in descending order and find the 2nd highest number

// 		List<Integer> sortedList = Arrays.stream(nums).boxed().sorted((num1, num2)->num1-num2).toList();

        List<Integer> ascSortedList = Arrays.stream(nums).boxed()
                .sorted().toList();
        List<Integer> descSortedList = Arrays.stream(nums).boxed()
                .sorted(Comparator.reverseOrder()).toList();
        Integer descSortedListSecondHighestDuplicates = Arrays.stream(nums).boxed()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        Integer descSortedListSecondHighestDistinct = Arrays.stream(nums).boxed().distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println("12.1. Sort the array of numbers in ascending order : " + ascSortedList);
        System.out.println("12.2. Sort the array of numbers in descending order : " + descSortedList);
        System.out.println("12.3. Sort the array of numbers in descending order and find 2nd highest number : " + descSortedListSecondHighestDuplicates);
        System.out.println("12.4. Sort the array of numbers in descending order and find 2nd highest number : " + descSortedListSecondHighestDistinct);
        System.out.println();

// 		13. Sort and print first the smallest numbers

        List<Integer> ascSortedListFirstThreeNum = Arrays.stream(nums).boxed()
                .sorted().limit(3).toList();

        System.out.println("13. Sort and print first three smallest numbers : " + ascSortedListFirstThreeNum);
        System.out.println();

// 		14. Repeating character in string.

        charHashSet.clear();
        System.out.println("14. Repeating character in string : ");
        input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> !ch.equals(' '))
                .filter(ch -> !charHashSet.add(ch))
                .forEach(ch -> System.out.print(ch + " "));
        System.out.println();

        HashMap<Character, Integer> repeatingCharacter = new HashMap<>();
        input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> !ch.equals(' '))
                .forEach(ch -> repeatingCharacter.put(ch, repeatingCharacter.getOrDefault(ch, 0) + 1));

        repeatingCharacter.forEach((k, v) -> {
            if (v > 1) System.out.print(k + " ");
        });
        System.out.println();
        System.out.println();

// 		15. Find the highest-paid Employee in each department.

        Map<String, Employeee> highestPaidEmplDeptWise = employees.stream()
                .collect(Collectors.groupingBy(
                        Employeee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employeee::getSalary)),
                                Optional::get
                        )
                ));

        System.out.println("15. Find the highest-paid employee in each department " + highestPaidEmplDeptWise);
        System.out.println();

// 		16. Partition a list of numbers into even and odd.

        Map<Boolean, List<Integer>> partitioned = Arrays.stream(nums).boxed().distinct()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);

        System.out.println("16. Partition a list of numbers into even and odd : " + evenNumbers + " " + oddNumbers);
        System.out.println();

// 		17. Convert a list to a map using streams.

        Map<String, Integer> listToMap = finalList.stream().collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("17. Convert a list to a map using streams : " + listToMap);
        System.out.println();

// 		18. Remove duplicates from a list using streams.

        List<Integer> distinctList = Arrays.stream(nums).boxed().distinct().toList();
        System.out.println("18. Remove duplicates from a list using streams : " + distinctList);
        System.out.println();

// 		19. Convert a list of strings to uppercase.

        List<String> strList = Arrays.asList("Ruqsana", "Daniya");
        List<String> finalStrList = strList.stream().map(String::toUpperCase).toList();

        System.out.println("19. Convert a list of strings to uppercase : " + finalStrList);
        System.out.println();

// 		20. Count empty strings in a list.

        AtomicInteger count = new AtomicInteger(0);
        strArrayList
                .forEach(s -> {
                    if (s.isEmpty())
                        count.getAndIncrement();
                });

        long emptyStringCount = strArrayList.stream().filter(String::isEmpty).count();

        System.out.println("20. Count empty strings in a list : " + count.get() + "By Simple filter : " + emptyStringCount);
        System.out.println();

// 		21. Remove empty strings from a list.

        List<String> nonEmptyList = strArrayList.stream().filter(str -> !str.isBlank()).toList();

        System.out.println("21. Remove empty strings from a list : " + nonEmptyList);
        System.out.println();

// 		22. Find the maximum number in a list.

        Integer maxNum = Arrays.stream(nums).boxed().max(Integer::compare).get();

        System.out.println("22. Maximum number in a list : " + maxNum);
        System.out.println();

// 		23. Find the minimum number in a list.

        Integer minNum = Arrays.stream(nums).boxed().min(Integer::compare).get();

        System.out.println("23. Minimum number in a list : " + minNum);
        System.out.println();

// 		24. Calculate the sum of all numbers.

        int sumNum = Arrays.stream(nums).sum();
        int sumNumWrapper = numList.stream().mapToInt(i -> i).sum();

        System.out.println("24. Sum of all numbers : " + sumNum + " Using wrapper classes : " + sumNumWrapper);
        System.out.println();

// 		25. Calculate the average of numbers.

        double avgNum = Arrays.stream(nums).mapToDouble(num -> num).average().orElse(0.0);

        System.out.println("25. Average of numbers : " + avgNum);
        System.out.println();

// 		26. Square each number and remove duplicates.

        List<Integer> numSquare = Arrays.stream(nums).boxed().distinct().map(num -> num * num).toList();

        System.out.println("26. Square each number and remove duplicates : " + numSquare);
        System.out.println();

// 		27. Sort a list of strings alphabetically.

        List<String> sortedStrList = strArrayList.stream().filter(s -> !s.isBlank()).sorted().toList();

        System.out.println("27. Sort a list of strings alphabetically : " + sortedStrList);
        System.out.println();


// 		29. Find the second-lowest number in a list.

        int secondLowestNum = Arrays.stream(nums).sorted().distinct().skip(1).findFirst().getAsInt();

        System.out.println("29. Second lowest number in a list : " + secondLowestNum);
        System.out.println();

// 		30. Check if a string is a palindrome.

        List<String> palindromeList = strArrayList.stream()
                .filter(str -> !str.isBlank() && str.contentEquals(new StringBuilder(str).reverse()))
                .toList();

        System.out.println("30. string is a palindrome : " + palindromeList);
        System.out.println();

// 		31. Count vowels and consonants in a string.

        String inp = "Ruqsana";

        long vowelCount = inp.chars().mapToObj(ch -> (char) ch).filter(ch -> "aeiou".indexOf(ch) != -1).count();
        long consonantCount = inp.chars().mapToObj(ch -> (char) ch).filter(ch -> "aeiou".indexOf(ch) == -1).count();

        System.out.println("31. vowels and consonants in a string : " + vowelCount + ", " + consonantCount);
        System.out.println();

// 		32. Find common elements between two lists.

        List<String> list2 = Arrays.asList("KhuratUlAin", "Saheba");

        List<String> commonElementsInList = strArrayList.stream().filter(list2::contains).toList();

        System.out.println("32. common elements between two lists : " + commonElementsInList);
        System.out.println();

// 		33. Merge two lists and remove duplicates.

        List<String> mergedList = Stream.concat(strArrayList.stream(), list2.stream())
                .filter(str -> !str.isBlank()).distinct().toList();

        System.out.println("33. Merge two lists and remove duplicates : " + mergedList);
        System.out.println();

// 		35. Group employees by department and count employees in each department.

        Map<String, Long> empCountDeptWise = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment, Collectors.counting()));

        System.out.println("35. Group employees by department and count employees in each department : " + empCountDeptWise);
        System.out.println();

// 		37. Find the average salary of employees.

        double avgSalary = employees.stream().mapToDouble(Employeee::getSalary).average().orElse(0.0);

        System.out.println("37. Average salary of employees : " + avgSalary);
        System.out.println();

// 		38. Partition employees by gender.

        Map<Boolean, List<Employeee>> partitionedMap = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getGender().equals("Male")));

        List<Employeee> maleEmp = partitionedMap.get(true);
        List<Employeee> femaleEmp = partitionedMap.get(false);

        System.out.println("38.1. Partition employees by gender - Male : " + maleEmp);
        System.out.println("38.2. Partition employees by gender - Female: " + femaleEmp);
        System.out.println();

// 		39. Get the names of all employees in a department.

        Map<String, List<Employeee>> empDeptWise = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment));

        System.out.println("39. Get names of all employees in a department : ");
        empDeptWise.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
        System.out.println();

// 		40. Find the youngest employee in a department.

        Map<String, Employeee> youngestEmp = employees.stream()
                .collect(Collectors.groupingBy(
                        Employeee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparing(Employeee::getAge)),
                                Optional::get
                        )));

        System.out.println("40. Youngest employee in a department : " + youngestEmp);
        System.out.println();

// 41. Find the oldest employee in a department.
// 		Map<String, Optional<Employeee>> oldestEmp = employees.stream()
// 		        .collect(Collectors.groupingBy(
// 		                     Employeee::getDepartment, Collectors.maxBy(Comparator.comparing(Employeee::getAge))));

        Map<String, Employeee> oldestEmp = employees.stream()
                .collect(Collectors.groupingBy(
                        Employeee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employeee::getAge)),
                                Optional::get)));

        System.out.println("41. Find the oldest employee in a department : " + oldestEmp);
        System.out.println();

// 42. Use Collectors.joining() to concatenate strings.
        String concatenatedString = strArrayList.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.joining(", "));

        System.out.println("42. Use Collectors.joining() to concatenate strings : " + concatenatedString);
        System.out.println();

// 44. Use reduce() to calculate factorial.
        int num = 5;
        int factorial = IntStream.rangeClosed(1, num).reduce(1, (a, b) -> a * b);
        System.out.println("44. Use reduce() to calculate factorial : " + factorial);
        System.out.println();

// 45. Use peek() for debugging stream operations.
        System.out.println("45. Use peek() for debugging stream operations :");
        long peekDemo = strArrayList.stream()
                .peek(name -> System.out.println("Original : " + name))
                .filter(name -> !name.isBlank() && name.length() > 6)
                .peek(name -> System.out.println("Filtered : " + name))
                .count();

        System.out.println("count : " + peekDemo);
        System.out.println();

// 46. Use anyMatch(), allMatch(), noneMatch() examples.
        boolean anyMatchString = strArrayList.stream()
                .anyMatch(name -> name.length() == 6);

        boolean allMatchString = strArrayList.stream()
                .filter(str -> !str.isBlank())
                .allMatch(name -> Character.isUpperCase(name.charAt(0)));


        boolean noneMatchString = strArrayList.stream()
                .noneMatch(name -> name.contains("z"));

        System.out.println("46. Use anyMatch(), allMatch(), noneMatch() examples : " + anyMatchString + " " + allMatchString + " " + noneMatchString);
        System.out.println();

// 48. Find the Most Frequent Element in a List
        int mostFrequentNum = numList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
        System.out.println("48. Find the Most Frequent Element in a List : " + mostFrequentNum);
        System.out.println();

// 50. Sort Map by Value in Descending Order
        System.out.println("50. Sort Map by Value in Descending Order : ");
        scores.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(System.out::println);
        System.out.println();
    }
}