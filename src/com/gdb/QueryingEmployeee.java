package src.com.gdb;

import java.util.Arrays;
import java.util.List;

public class QueryingEmployeee {

    public static void main(String[] args) {

        List<Employeee> employees = getEmployees();

        // 1. Count the employees based on gender
        System.out.println("-----1. Counting the employees based on gender------");

        // 2. department wise gender count
        System.out.println("-----2. Department wise gender count------");

        // 3. Average salary of Male employees, Female employees and other employees
        System.out.println("-----3. Average salaries of employees based on gender------");

        // 4. print the employee details with max salary and min salary
        System.out.println("------4. Employees with max and min salary-------");

        //5. print the employees who joined after 2015
        System.out.println("------5. employees Joined after 2015---------");

        //6. print the employees whose name starts with 'T'
        System.out.println("-------6. employees Name starts with T---------");

        //7. print the employees who know 'Java'
        System.out.println("------7. employees Knows Java----------");

        //8. print the employees who know 'Java' and 'C++'
        System.out.println("------8. employees Knows Java & C++  ----------");

        //9. print the employees and their salaries who earn more in their department
        System.out.println("-------9. employees with MaxSalary Department wise--------");

        //10. print the employees and their salaries who earn least in their department
        System.out.println("------10. employees with MinSalary Department wise--------");

        //11. print the employees and their salaries who earn more than 50,000
        System.out.println("------11. employees with Salary > 50000--------");

        //12. print the employees whose techStack start with 'R'
        System.out.println("-------12. employees TechStack starts with R--------");

        //13. each gender count in CIS department
        System.out.println("-----13. Gender count in a particular(CIS) Department--------");

        //14. print the employees who know 'Java' and 'C++' in DX department
        System.out.println("-------14. employees Knows Java & C++ in DX Department----------");

        //15. print the employees who joined after 2015 in CIS department
        System.out.println("-------15. employees Joined after 2015 in CIS Department---------");

        //16. print the employees whose name starts with 'T' in ENG department
        System.out.println("-------16. employees Name starts with T in ENG Department---------");

        //17. print the employees whose name contains 'u' in the list
        System.out.println("-------17. employees Name contains 'u'---------");

        //18. print the employees whose techStack as in the given list.
        System.out.println("-------18. employees TechStack is same as the given list---------");

        //19. print the employee who has the same techStack as the employee with id 1.
        System.out.println("-------19. employees with same TechStack as the employee with id 1---------");

        //20. print the employees who have the same techStacks
        System.out.println("-------20. employees with same TechStacks---------");

        //21. sort the employees based on their salaries
        System.out.println("------21. Employees sorted based on their salaries--------");

        //22. sort the employees based on their salaries in descending order
        System.out.println("------22. Employees sorted based on their salaries in descending order--------");

        //23. sort the employees based on their salaries and if the salaries are same then sort them based on their age
        System.out.println("------23. Employees sorted based on their salaries and if the salaries are same then sort them based on their age--------");

        //24. sort the employees based on their salaries in descending order and if the salaries are same, then sort them based on their age in descending order
        System.out.println("------24. Employees sorted based on their salaries in descending order and if the salaries are same then sort them based on their age in descending order--------");

        //25. sort the employees based on their salaries in descending order and if the salaries are same, then sort them based on their age in ascending order
        System.out.println("------25. Employees sorted based on their salaries in descending order and if the salaries are same then sort them based on their age in ascending order--------");

        //26. contains Gay, if present print first gay
        System.out.println("------26. contains Gay, if present print first gay--------");

        //27. Second-highest salary
        System.out.println("------27. Second highest salary--------");


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
