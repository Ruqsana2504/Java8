package src.com.javatechie.stream.sort;

import src.com.javatechie.stream.api.example.EmployeeDatabase;
import src.com.javatechie.stream.api.example.Employee;

import java.util.ArrayList;
import java.util.List;

public class SortListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(3);
        list.add(12);
        list.add(4);

        List<Employee> employeeList = EmployeeDatabase.getEmployees();

        //Sorting Objects Traditional way
       /* employeeList.sort((emp1, emp2) -> (int) (emp1.getSalary() - emp2.getSalary()));
        System.out.println(employeeList);

        //Using Streams
        employeeList.stream().sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())).forEach(System.out::println);
        employeeList.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);
        //Method Reference
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);*/

        /* #############################################################################################################################*/

        //Sorting primitive data types
      /*  //Traditional way
        Collections.sort(list); //Ascending order
        Collections.reverse(list); //Descending order
        System.out.println(list);

        //Using Streams API
        list.stream().sorted().forEach(System.out::println); //Ascending order
        list.stream().sorted((o1, o2) -> o2 - o1).forEach(System.out::println);  //Descending order
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); //Descending order*/

    }
}
