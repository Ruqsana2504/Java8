package src;

import java.util.Arrays;
import java.util.List;

class ShrishtiTechAcademy {

    public static void main(String[] args) {

        List<String> courseList = List.of("Java", "Spring", "Angular", "HTML", "Javascript");

        //Iterate over list and find elements which contains 'a'. Return sorted array
        courseList.stream()
                .filter(course -> course.contains("a"))
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        courseList.stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        System.out.println();
        String[] names = {"Reena", "John", "Zaid", "Kumar", "Angel"};
        Arrays.stream(names).filter(str -> str.contains("a")).forEach(System.out::println);

        System.out.println();
        //Work on part of array
        Arrays.stream(names, 2, 5).forEach(System.out::println);

    }
}