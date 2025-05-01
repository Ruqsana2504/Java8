package src.com.gdb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueryingEmployeee {

    public static void main(String[] args) {

        List<Employeee> employees = getEmployees();

        // 1. Count the employees based on gender
        System.out.println("-------1. Counting the employees based on gender------");
        long maleEmployeesCount = employees.stream().filter(emp -> "Male".equalsIgnoreCase(emp.getGender())).count();
        long femaleEmployeesCount = employees.stream().filter(emp -> "Female".equalsIgnoreCase(emp.getGender())).count();
        long otherEmployeesCount = employees.stream().filter(emp -> !"Male".equalsIgnoreCase(emp.getGender()) && !"Female".equalsIgnoreCase(emp.getGender())).count();
        System.out.println("Male Employees : " + maleEmployeesCount + "  Female Employees : " + femaleEmployeesCount + "  Other Employees : " + otherEmployeesCount);
        //Second method using a map
        Map<String, Long> employeeCountBasedOnGender = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getGender, Collectors.counting()));
        System.out.println("Employee count based on gender : " + employeeCountBasedOnGender);
        System.out.println();

        // 2. department wise gender count
        System.out.println("-------2. Department wise gender count------");
        Map<String, Map<String, Long>> deptWiseGenderCount = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment, Collectors.groupingBy(Employeee::getGender, Collectors.counting())));
        System.out.println(deptWiseGenderCount);
        System.out.println();

        // 3. Average salary of Male employees, Female employees and other employees
        System.out.println("-------3. Average salaries of employees based on gender------");
        double maleAvgSalary = employees.stream()
                .filter(emp -> "Male".equalsIgnoreCase(emp.getGender()))
                .mapToDouble(Employeee::getSalary).average().orElse(0);
        double femaleAvgSalary = employees.stream()
                .filter(emp -> "Female".equalsIgnoreCase(emp.getGender()))
                .mapToDouble(Employeee::getSalary).average().orElse(0);
        double otherAvgSalary = employees.stream()
                .filter(emp -> !"Male".equalsIgnoreCase(emp.getGender()) && !"Female".equalsIgnoreCase(emp.getGender()))
                .mapToDouble(Employeee::getSalary).average().orElse(0);
        System.out.println("maleAvgSalary: " + maleAvgSalary + "    femaleAvgSalary: " + femaleAvgSalary + "     otherAvgSalary: " + otherAvgSalary);
        System.out.println();

        // 4. print the employee details with max salary and min salary
        System.out.println("-------4. Employees with max and min salary-------");
        Employeee maxSalaryEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employeee::getSalary)).get();
        Employeee minSalaryEmployee = employees.stream()
                .min(Comparator.comparingDouble(Employeee::getSalary)).get();
        System.out.println("Max Salary Employee : " + maxSalaryEmployee.getName());
        System.out.println("Min Salary Employee : " + minSalaryEmployee.getName());
        System.out.println();

        //5. print the employees who joined after 2015
        System.out.println("-------5. employees Joined after 2015---------");
        List<String> employeeJoinedAfter2015 = employees.stream()
                .filter(emp -> emp.getYearOfJoining() > 2015)
                .map(Employeee::getName).toList();
        System.out.println(employeeJoinedAfter2015);
        System.out.println();

        //6. print the employees whose name starts with 'T'
        System.out.println("-------6. employees Name starts with T---------");
        List<String> employeesNameStartingWithT = employees.stream()
                .map(Employeee::getName)
                .filter(name -> name.startsWith("T")).toList();
        System.out.println(employeesNameStartingWithT);
        System.out.println();

        //7. print the employees who know 'Java'
        System.out.println("-------7. employees Knows Java----------");
        List<String> employeesWhoKnowsJava = employees.stream()
                .filter(emp -> emp.getTechStack().contains("Java"))
                .map(Employeee::getName).toList();
        System.out.println(employeesWhoKnowsJava);
        System.out.println();

        //8. print the employees who know 'Java' and 'C++'
        System.out.println("-------8. employees Knows Java & C++  ----------");
        List<String> employeesKnowsJavaAndCPlusPlus = employees.stream()
                .filter(emp -> emp.getTechStack().contains("Java") && emp.getTechStack().contains("C++"))
                .map(Employeee::getName).toList();
        System.out.println(employeesKnowsJavaAndCPlusPlus);
        System.out.println();

        //9. print the employees and their salaries who earn more in their department
        System.out.println("-------9. employees with MaxSalary Department wise--------");
        Map<String, Employeee> employeesWithMaxSalaryDeptWise = employees.stream()
                .collect(Collectors.toMap(Employeee::getDepartment, Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(Employeee::getSalary))));
        System.out.println(employeesWithMaxSalaryDeptWise);
        System.out.println();

        //10. print the employees and their salaries who earn least in their department
        System.out.println("-------10. employees with MinSalary Department wise--------");
        Map<String, Employeee> employeesWithMinSalaryDeptWise = employees.stream()
                .collect(Collectors.toMap(Employeee::getDepartment, Function.identity(), BinaryOperator.minBy(Comparator.comparingDouble(Employeee::getSalary))));
        System.out.println(employeesWithMinSalaryDeptWise);
        System.out.println();

        //11. print the employees and their salaries who earn more than 50,000
        System.out.println("-------11. employees with Salary > 50,000--------");
        List<String> employeesWithSalaryGreaterThan50000 = employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .map(Employeee::getName).toList();
        System.out.println(employeesWithSalaryGreaterThan50000);
        System.out.println();

        //12. print the employees whose techStack start with 'R'
        System.out.println("-------12. employees TechStack starts with R--------");
        List<Employeee> employeesTechStackStartsWithR = employees.stream()
                .filter(emp -> emp.getTechStack().stream().anyMatch(tech -> tech.startsWith("R"))).toList();
        System.out.println(employeesTechStackStartsWithR);
        System.out.println();

        //13. each gender count in CIS department
        System.out.println("-------13. Gender count in a particular(CIS) Department--------");
        Map<String, Long> genderCountInCISDept = employees.stream()
                .filter(emp -> "CIS".equalsIgnoreCase(emp.getDepartment()))
                .collect(Collectors.groupingBy(Employeee::getGender, Collectors.counting()));
        System.out.println(genderCountInCISDept);
        System.out.println();

        //14. print the employees who know 'Java' and 'C++' in DX department
        System.out.println("-------14. employees Knows Java & C++ in DX Department----------");
        List<String> employeesWhoKnowsJavaCPlusPlusInDXDept = employees.stream()
                .filter(emp -> "DX".equalsIgnoreCase(emp.getDepartment()) && emp.getTechStack().contains("Java") && emp.getTechStack().contains("C++"))
                .map(Employeee::getName).toList();
        System.out.println(employeesWhoKnowsJavaCPlusPlusInDXDept);
        System.out.println();

        //15. print the employees who joined after 2015 in CIS department
        System.out.println("-------15. employees Joined after 2015 in CIS Department---------");
        List<String> employeesInCISDeptJoinedAfter2015 = employees.stream()
                .filter(emp -> "CIS".equalsIgnoreCase(emp.getDepartment()) && 2015 < emp.getYearOfJoining())
                .map(Employeee::getName).toList();
        System.out.println(employeesInCISDeptJoinedAfter2015);
        System.out.println();

        //16. print the employees whose name starts with 'T' in ENG department
        System.out.println("-------16. employees Name starts with T in ENG Department---------");
        List<String> employeeNameStartsWithTInEngDept = employees.stream()
                .filter(emp -> "ENG".equalsIgnoreCase(emp.getDepartment()) && emp.getName().startsWith("T"))
                .map(Employeee::getName).toList();
        System.out.println(employeeNameStartsWithTInEngDept);
        System.out.println();

        //17. print the employees whose name contains 'u' in the list
        System.out.println("-------17. employees Name contains 'u'---------");
        List<String> employeeNamesContainingU = employees.stream()
                .map(Employeee::getName)
                .filter(name -> name.contains("u")).toList();
        System.out.println(employeeNamesContainingU);
        System.out.println();

        //18. print the employees whose techStack as in the given list.
        System.out.println("-------18. employees TechStack is same as the given list---------");
        List<String> techStack = Arrays.asList("Java", "JavaScript", "C#");
        List<Employeee> employeesWithSameTechStack = employees.stream()
                .filter(emp -> emp.getTechStack().containsAll(techStack)).toList();
        employeesWithSameTechStack.forEach(emp -> System.out.print(emp.getName() + " "));
        System.out.println();
        System.out.println();

        //19. print the employee who has the same techStack as the employee with id 1.
        System.out.println("-------19. employees with same TechStack as the employee with id 1---------");
        List<String> employeeTechStackWithId1 = employees.stream()
                .filter(emp -> emp.getId() == 1)
                .map(Employeee::getTechStack)
                .flatMap(List::stream).toList();
        List<Employeee> employeesWithSameTechStackAsEmployeeWithId1 = employees.stream()
                .filter(emp -> emp.getTechStack().containsAll(employeeTechStackWithId1)).toList();
        System.out.println(employeesWithSameTechStackAsEmployeeWithId1);
        System.out.println();

        //20. print the employees who have the same techStacks
        System.out.println("-------20. employees with same TechStacks---------");
        //Bruce and Tony have the same techStack, similarly Antman and Patsy have the same techStack.
        List<List<Object>> employeesWithSameTechStacksAndTech = employees.stream()
                .flatMap(emp -> employees.stream()
                        .filter(emp1 -> !emp1.equals(emp) && emp.getTechStack().containsAll(emp1.getTechStack()))
                        .map(temp -> Arrays.asList(emp.getName(), temp.getName(), emp.getTechStack())))
                .distinct().toList();
        System.out.println(employeesWithSameTechStacksAndTech);
        System.out.println();

        //21. sort the employees based on their salaries
        System.out.println("-------21. Employees sorted based on their salaries--------");
        List<Employeee> employeeSortedBasedOnSalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary)).toList();
        System.out.println(employeeSortedBasedOnSalary);
        System.out.println();

        //22. sort the employees based on their salaries in descending order
        System.out.println("-------22. Employees sorted based on their salaries in descending order--------");
        List<Employeee> employeeSortedBasedOnSalaryDesc = employees.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary).reversed()).toList();
        System.out.println(employeeSortedBasedOnSalaryDesc);
        System.out.println();

        //23. sort the employees based on their salaries and if the salaries are same then sort them based on their age
        System.out.println("-------23. Employees sorted based on their salaries and if the salaries are same then sort them based on their age--------");
        List<Employeee> employeesSortedBasedOnSalariesAndAge = employees.stream()
                .sorted((emp1, emp2) -> emp1.getSalary() == emp2.getSalary() ? emp1.getAge() - emp2.getAge() : Double.compare(emp1.getSalary(), emp2.getSalary()))
                .toList();
        System.out.println(employeesSortedBasedOnSalariesAndAge);
        System.out.println();

        //24. sort the employees based on their salaries in descending order and if the salaries are same, then sort them based on their age in descending order
        System.out.println("-------24. Employees sorted based on their salaries in descending order and if the salaries are same then sort them based on their age in descending order--------");
        List<Employeee> employeesSortedBasedOnSalariesInDescendingOrderAndAgeInDescendingOrder = employees.stream()
                .sorted((emp1, emp2) -> emp1.getSalary() == emp2.getSalary() ? emp2.getAge() - emp1.getAge() : Double.compare(emp2.getSalary(), emp1.getSalary()))
                .toList();
        System.out.println(employeesSortedBasedOnSalariesInDescendingOrderAndAgeInDescendingOrder);
        System.out.println();

        //25. sort the employees based on their salaries in descending order and if the salaries are same, then sort them based on their age in ascending order
        System.out.println("-------25. Employees sorted based on their salaries in descending order and if the salaries are same then sort them based on their age in ascending order--------");
        List<Employeee> employeesSortedBasedOnSalariesInDescendingOrderAndAgeInAscendingOrder = employees.stream()
                .sorted((emp1, emp2) -> emp1.getSalary() == emp2.getSalary() ? emp2.getAge() - emp1.getAge() : Double.compare(emp1.getSalary(), emp2.getSalary()))
                .toList();
        System.out.println(employeesSortedBasedOnSalariesInDescendingOrderAndAgeInAscendingOrder);
        System.out.println();

        //26. contains Gay, if present print first gay
        System.out.println("-------26. contains Gay, if present print first gay--------");
        Employeee gayEmployee = employees.stream()
                .filter(emp -> !emp.getGender().equalsIgnoreCase("Male") && !emp.getGender().equalsIgnoreCase("Female"))
                .findFirst().orElse(null);
        System.out.println(gayEmployee);
        System.out.println();

        //27. Second-highest salary
        System.out.println("-------27. Second highest salary--------");
        Employeee employeeWithSecondHighestSalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary).reversed())
                .skip(1).findFirst().get();
        System.out.println(employeeWithSecondHighestSalary);
        System.out.println();

    }

    private static List<Employeee> getEmployees() {
        Employeee e1 = new Employeee(1, "Antman", 39, "Male", "DX", 2011, 100000, Arrays.asList("Ruby", "Java", "C++"));
        Employeee e2 = new Employeee(2, "Sam", 24, "Male", "ENG", 2017, 76000, Arrays.asList(".Net", "JavaScript", "C++"));
        Employeee e3 = new Employeee(8, "carol", 30, "Female", "CIS", 2013, 85000, Arrays.asList("Java", "C#", "python"));
        Employeee e4 = new Employeee(3, "Tony", 25, "Male", "HR", 2010, 90000, Arrays.asList("Angular", "Python", "C"));
        Employeee e5 = new Employeee(4, "Hercules", 42, "Male", "DX", 2015, 28000, Arrays.asList("Java", ".Net", "React"));
        Employeee e6 = new Employeee(9, "Bruce", 27, "Male", "CIS", 2020, 68000, Arrays.asList("Java", "JavaScript", "C#"));
        Employeee e7 = new Employeee(6, "Patsy", 28, "Female", "HR", 2022, 30000, Arrays.asList("C++", "Ruby", "Java"));
        Employeee e8 = new Employeee(7, "Natasha", 55, "Female", "HR", 2020, 53000, Arrays.asList("C#", "Python", "C++"));
        Employeee e9 = new Employeee(5, "Wanda", 31, "Female", "ENG", 2023, 25000, Arrays.asList(".Net", "Ruby", "C#"));
        Employeee e10 = new Employeee(10, "Vision", 32, "Gay", "CIS", 2021, 34000, Arrays.asList("Java", ".Net", "C#"));
        Employeee e11 = new Employeee(11, "Wasp", 33, "Female", "DX", 2001, 80070, Arrays.asList("Ruby", "JavaScript", "C++"));
        Employeee e12 = new Employeee(12, "Thor", 34, "Male", "ENG", 2018, 56000, Arrays.asList(".Net", "Java", "C++"));
        Employeee e13 = new Employeee(13, "Thanos", 35, "Male", "CIS", 2019, 67000, Arrays.asList("JavaScript", "C#", "Java"));

        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
    }
}
