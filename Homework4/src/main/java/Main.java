import java.util.*;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = faker.name().fullName();
            Set<Project> preferences = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                String projectName = faker.commerce().productName();
                preferences.add(new Project(projectName));
            }
            students.add(new Student(name, preferences));
        }

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String projectName = faker.commerce().productName();
            projects.add(new Project(projectName));
        }
        StuProjMatch matching = new StuProjMatch(students, projects);
        System.out.println("Studentii cu preferinte mai putine decat media:");
        matching.lessThanAverage().forEach(System.out::println);
        System.out.println("Matching-ul maxim este:");
        matching.maxMatch().forEach(System.out::println);
    }
}
