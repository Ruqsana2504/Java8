package src.com.javatechie.stream.api.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

    public static List<Employee> evaluateTaxUsers(String input) {
        //Use of Filters
        List<Employee> employeeList = EmployeeDatabase.getEmployees();
        return (input.equalsIgnoreCase("tax"))
                ? employeeList.stream().filter(emp -> emp.getSalary() > 500000).collect(Collectors.toList())
                : employeeList.stream().filter(emp -> emp.getSalary() <= 500000).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(evaluateTaxUsers("tax"));
    }

}
