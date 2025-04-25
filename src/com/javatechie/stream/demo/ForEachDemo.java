package src.com.javatechie.stream.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Murrit");
        list1.add("John");
        list1.add("Peter");
        list1.add("Marek");
        list1.add("Mark");

//        for (String s : list1) {
//            System.out.println(s);
//        }

//        list1.stream().forEach((s) -> System.out.println(s));
//        list1.forEach(System.out::println);

        list1.stream().filter(str -> str.length() > 4).forEach(System.out::println);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
//        map.forEach((k, v) -> System.out.println("Key : " + k + " " + "Value : " + v));
//        map.entrySet().forEach(obj -> System.out.println(obj));
        map.entrySet().stream().filter(obj -> obj.getKey() % 2 == 0).forEach(System.out::println);
    }
}
