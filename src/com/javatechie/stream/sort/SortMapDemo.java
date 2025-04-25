package src.com.javatechie.stream.sort;

import src.com.javatechie.stream.api.example.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("ten", 10);
        map.put("four", 4);
        map.put("two", 2);

        Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
        employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
        employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
        employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
        employeeMap.put(new Employee(176, "Prakash", "SOCIAL", 1200000), 120);

        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
//        System.out.println(employeeMap);



        /*List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

//        entries.sort((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));
//        entries.sort(Comparator.comparing(Map.Entry::getKey));
        entries.sort(Map.Entry.comparingByKey());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
    }
}
