import java.util.List;

public class ShrishtiTechAcademy {

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

    }
}