package Stream;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {

    record Student(String name, int age, double gpa, String major) {
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("An", 20, 3.5, "CNTT"),
                new Student("Bảo", 21, 2.8, "CNTT"),
                new Student("Chi", 20, 3.8, "Kinh tế"),
                new Student("Dũng", 22, 3.2, "CNTT"),
                new Student("Em", 21, 2.5, "Kinh tế")
        );

        // 1. filter — lọc SV CNTT có GPA >= 3.0
        List<Student> cnttGood = students.stream()
                .filter(s -> s.major().equals("CNTT"))
                .filter(s -> s.gpa() >= 3.0)
                .collect(Collectors.toList());
        // → [An, Dũng]

        // 2. map — lấy danh sách tên
        List<String> names = students.stream()
                .map(Student::name)          // method reference
                .collect(Collectors.toList());
        // → [An, Bảo, Chi, Dũng, Em]

        // 3. sorted — sắp xếp theo GPA giảm dần
        List<Student> byGpa = students.stream()
                .sorted((a, b) -> Double.compare(b.gpa(), a.gpa()))
                .collect(Collectors.toList());
        // → [Chi(3.8), An(3.5), Dũng(3.2), Bảo(2.8), Em(2.5)]

        // 4. reduce — tính tổng GPA
        double totalGpa = students.stream()
                .map(Student::gpa)
                .reduce(0.0, Double::sum);
        // → 15.8

        // 5. Pipeline dài — tên SV CNTT GPA >= 3.0, sắp xếp tên, viết hoa
        List<String> result = students.stream()
                .filter(s -> s.major().equals("CNTT"))
                .filter(s -> s.gpa() >= 3.0)
                .map(Student::name)
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        // → [AN, DŨNG]

        // Practice
        // 1. Lấy danh sách tên của tất cả SV dưới 21 tuổi
        List<String> name = students.stream()
                .filter(s -> s.age() < 21)
                .map(Student::name)
                .toList();


        // 2. Đếm có bao nhiêu SV ngành Kinh tế
        long count = students.stream()
                .filter(s -> s.major().equals("Kinh tế"))
                .count();


        // 3. Tính GPA trung bình của toàn bộ sinh viên
        double avgGpa = students.stream()
                .collect(Collectors.averagingDouble(Student::gpa));
    }
}