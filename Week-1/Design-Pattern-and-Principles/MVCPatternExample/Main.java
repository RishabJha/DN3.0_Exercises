public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        StudentView studentView = new StudentView();

        StudentController controller = new StudentController(student, studentView);
        controller.setName("Rishab");
        controller.setId(124);
        controller.setGrade('A');

        controller.displayStudentDetails();
    }
}
