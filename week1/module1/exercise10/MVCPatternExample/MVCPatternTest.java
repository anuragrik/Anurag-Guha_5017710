package week1.module1.exercise10.MVCPatternExample;

public class MVCPatternTest {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 123, "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentId(456);
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
