package src.com.gdb;

import java.util.List;

public class Employeee {

    private final int id;
    private final String name;
    private final int age;
    private final String gender;
    private final String department;
    private final int yearOfJoining;
    private final double salary;
    private final List<String> techStack;

    public Employeee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary, List<String> techStack) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.techStack = techStack;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                ", techStack=" + techStack +
                '}';
    }
}
