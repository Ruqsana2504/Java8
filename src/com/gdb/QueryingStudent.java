package src.com.gdb;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QueryingStudent {

    static void main() {
        List<Student> studentsList = getStudents();

        //Sort Students based on First Name and Last Name - Push nulls to the end
        System.out.println("------- Sort Students based on First Name and Last Name - Push nulls to the end ------");
        List<Student> sortedList = studentsList.stream()
                .sorted(Comparator
                        .comparing(Student::getLastName, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Student::getLastName, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
        System.out.println(sortedList);

    }

    public static List<Student> getStudents() {
        return List.of(new Student(null, "Doe", 85),
                new Student("Jane", "Smith", 92),
                new Student("Jane", "Johnson", 78),
                new Student("Bob", null, 90),
                new Student(null, null, 20));
    }
}
