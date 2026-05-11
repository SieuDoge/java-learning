package exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String id) {
        super("Student with id " + id + " not found");
    }

}
