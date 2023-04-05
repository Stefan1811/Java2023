public class Pereche {
    private Student student;
    private Project project;

    public Pereche(Student student,Project project) {
        this.student = student;
        this.project=project;
    }

    public Project getProject() {
        return project;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Pereche{" +
                "student=" + student.getName() +
                ", project=" + project.getName() +
                '}';
    }
}
