package repository;

import exception.StudentNotFoundException;
import model.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    void update(String id, Student student) throws StudentNotFoundException;
    void delete(String id) throws StudentNotFoundException;
    List<Student> findAll();
    Student findById(String id);
}
