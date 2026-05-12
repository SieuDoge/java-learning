package service;

import repository.StudentRepository;
import model.Student;

import java.util.stream.*;
import java.util.List;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    // CRUD — delegate xuống repo
    public void addStudent(String name, int age, double gpa, String major) {
        Student student = new Student(name, age, gpa, major);
        repository.save(student);
    }

    public void updateGpa(String id, double newGpa) {
        Student old = repository.findById(id);
        old.setGpa(newGpa);
        repository.update(id, old);
    }

    public void deleteStudent(String id) {
        repository.delete(id);
    }

    public Student getById(String id) {
        return repository.findById(id);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public List<Student> filterByMajor(String major) {
        return repository.findAll().stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public List<Student> topByGpa(int n) {
        return repository.findAll().stream()
                .sorted((a, b) -> Double.compare(b.getGpa(), a.getGpa()))
                .limit(n)
                .collect(Collectors.toList());
    }

    public double averageGpa(){
        return repository.findAll().stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }
}
