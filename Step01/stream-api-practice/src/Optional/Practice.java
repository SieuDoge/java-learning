package Optional;

import java.util.List;
import java.util.Optional;

import static Optional.OptionalDemo.findByName;

public class Practice {
    record Student(String name, int age, double gpa) {}

    static Optional<Student> findByName(List<Student> students, String name) {
        return students.stream()
                .filter(s -> s.name().equals(name))
                .findFirst(); // trả về Optional<Student>
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("An", 20, 3.5),
                new Student("Bảo", 21, 2.8),
                new Student("Chi", 20, 3.8)
        );

        Student Dung = findByName(students, "Dũng")
                .orElse(new Student("Unk",0,0.0));
        System.out.println(Dung.name());
        findByName(students, "Chi")
                .ifPresent(s -> System.out.println(s.name() + " Gpa: " + s.gpa));
        String name = findByName(students, "An")
                .map(s -> s.name())
                .map(String::toUpperCase)
                .orElse("Không tìm thấy");
        System.out.println(name); // AN



    }
}
