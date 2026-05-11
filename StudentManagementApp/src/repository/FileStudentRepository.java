package repository;

import exception.StudentNotFoundException;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStudentRepository implements StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void save(Student student) {
        this.students.add(student);
    }

    public void update(String id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, student);
                return;
            }
        }
        throw new StudentNotFoundException(id);
    }

    public void delete(String id) throws StudentNotFoundException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return;
            }
        }
        throw new StudentNotFoundException(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(students); // trả về defensive copy là đủ
    }

    public Student findById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) return student;
        }
        throw new StudentNotFoundException(id);
    }


    // FILE I/O

    public void saveToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadFromFile(String path) {
        File file = new File(path);
        if (!file.exists()) {return;}
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            students.clear();
            while ((line = reader.readLine()) != null){
                if (!line.isBlank()) students.add(Student.fromFileString(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
