public class StudentController {
    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

    public String getName() {
        return student.getName();
    }

    public void setName(String name) {
        student.setName(name);
    }

    public int getId() {
        return student.getId();
    }

    public void setId(int id) {
        student.setId(id);
    }

    public char getGrade() {
        return student.getGrade();
    }

    public void setGrade(char grade) {
        student.setGrade(grade);
    }

    public void displayStudentDetails() {
        studentView.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }

}
