package Optional;

import java.util.*;

public class OptionalDemo {

    record Student(String name, int age, double gpa) {}

    static Optional<Student> findByName(List<Student> students, String name) {
        return students.stream()
                .filter(s -> s.name().equals(name))
                .findFirst(); // trả về Optional<Student>
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("An", 20, 3.5),
                new Student("Bảo", 21, 2.8)
        );

        // 1. orElse — tìm không thấy thì dùng default
        Student found = findByName(students, "Chi")
                .orElse(new Student("Unknown", 0, 0.0));
        System.out.println(found.name()); // Unknown

        // 2. orElseThrow — tìm không thấy thì throw
        Student an = findByName(students, "An")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy SV"));
        System.out.println(an.name()); // An

        // 3. ifPresent — chỉ làm gì đó khi có giá trị
        findByName(students, "Bảo")
                .ifPresent(s -> System.out.println(s.name() + " GPA: " + s.gpa()));
        // Bảo GPA: 2.8

        // 4. map — transform giá trị bên trong
        String name = findByName(students, "An")
                .map(Student::name)
                .map(String::toUpperCase)
                .orElse("Không tìm thấy");
        System.out.println(name); // AN

        // TRÁNH dùng thế này — đánh mất ý nghĩa của Optional
        Optional<Student> opt = findByName(students, "An");
        if (opt.isPresent()) {       // chống null bằng if — y như cũ
            System.out.println(opt.get().name());
        }
    }
}