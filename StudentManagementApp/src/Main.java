import repository.FileStudentRepository;
import service.StudentService;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        FileStudentRepository repository = new FileStudentRepository();
        StudentService service = new StudentService(repository);
        new Menu(service, repository).run();
    }
}