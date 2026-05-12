package ui;

import exception.StudentNotFoundException;
import model.Student;
import repository.FileStudentRepository;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final StudentService service;
    private final FileStudentRepository repository;
    private final Scanner scanner = new Scanner(System.in);
    private final String filePath = "student.txt";

    public Menu(StudentService studentService, FileStudentRepository repository) {
        this.service = studentService;
        this.repository = repository;
        this.repository.loadFromFile(filePath);
    }

    public void run(){
        while(true){
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice){
                case 1 -> addStudent();
                case 2 -> viewAllStudent();
                case 3 -> updateGPA();
                case 4 -> deleteStudent();
                case 5 -> findStudentByID();
                case 6 -> filterMajor();
                case 7 -> topGPA();
                case 8 -> AvgGPA();
                case 0 -> {                          // ← thêm case thoát
                    repository.saveToFile(filePath);
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void AvgGPA() {
        System.out.print("AVG GPA: " + service.averageGpa());
    }

    private void topGPA() {
        System.out.println("Số lượng sinh viên cần in: ");
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Student> students = service.topByGpa(n);
        if(students.isEmpty()){
            System.out.println("Không có dữ liệu.");
            return;
        }
        students.forEach(System.out::println);
    }

    private void filterMajor() {
        System.out.println("Major: ");
        String major = scanner.nextLine().trim();
        List<Student> students = service.filterByMajor(major);
        if(students.isEmpty()){
            System.out.println("No students found");
            return;
        }
        students.forEach(System.out::println);
    }

    private void findStudentByID() {
        System.out.println("Enter Student ID: ");
        String studentID = scanner.nextLine().trim();

        Student student = service.getById(studentID);
        System.out.println(student);

    }

    private void deleteStudent() {
        System.out.println("Enter Student ID: ");
        String studentID = scanner.nextLine().trim();

        service.deleteStudent(studentID);
    }

    private void updateGPA() {
        try {
            System.out.print("Student ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("New GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine().trim());

            service.updateGpa(id, gpa);

            System.out.println("Update successful!");

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid GPA format.");
        }
    }

    private void viewAllStudent() {
        System.out.println("Toàn bộ danh sách sinh viên");
        List<Student> students = service.getAll();
        if(students.isEmpty()){
            System.out.println("Danh sách trống!");
            return;
        }
        students.forEach(System.out::println);

    }

    private void addStudent() {
        System.out.print("Tên: ");
        String name = scanner.nextLine();

        System.out.print("Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Ngành: ");
        String major = scanner.nextLine();

        service.addStudent(name, age, gpa, major); // gọi service, không tạo Student trực tiếp
    }

    public void printMenu(){
        System.out.println("=== Menu ===");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update GPA");
        System.out.println("4. Delete Student");
        System.out.println("5. Find Student by ID");
        System.out.println("6. Filter Students by Major");
        System.out.println("7. Top GPA");
        System.out.println("8. AVG GPA");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice : ");
    }

}
