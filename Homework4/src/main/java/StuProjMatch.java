import java.util.*;
import java.util.stream.Collectors;


public class StuProjMatch {
    private List<Student> students;
    private List<Project> projects;

    public StuProjMatch(List<Student> students,List<Project> projects) {
        this.students=students;
        this.projects=projects;
    }
    public List<Student> lessThanAverage(){
        int avg = (int) students.stream()
                .mapToInt(s -> s.getProj_pref().size())
                .average()
                .orElse(0);
        return students.stream()
                .filter(s -> s.getProj_pref().size() < avg)
                .collect(Collectors.toList());
    }
    public List<Pereche>maxMatch() {
        List<Pereche> matching = new ArrayList<>();
        Set<Project> projAssign = new HashSet<>();
        for (Student student : students) {
            for (Project project : student.getProj_pref()) {
                if (!projAssign.contains(project)) {
                    matching.add(new Pereche(student, project));
                    projAssign.add(project);
                    break;
                }
            }
        }
        return matching;
    }

}
