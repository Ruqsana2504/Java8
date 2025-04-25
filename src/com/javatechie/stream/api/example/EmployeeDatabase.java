package src.com.javatechie.stream.api.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(176, "Roshan", "IT", 600000));
        list.add(new Employee(388, "Bikash", "CIVIL", 900000));
        list.add(new Employee(470, "Bimal", "DEFENCE", 500000));
        list.add(new Employee(624, "Sourav", "CORE", 400000));
        list.add(new Employee(176, "Prakash", "IT", 1200000));
        return list;
    }
}
