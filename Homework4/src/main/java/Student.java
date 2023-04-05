import java.util.*;
public class Student {
    private String name;
    private Set<Project> proj_pref;

    public Student(String name,Set<Project> proj_pref) {
        this.name=name;
        this.proj_pref = proj_pref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProj_pref() {
        return proj_pref;
    }

    public void setProj_pref(Set<Project> proj_pref) {
        this.proj_pref = proj_pref;
    }

    @Override
    public String toString() {
        return name + " (" + proj_pref.size() + " project-preferences)";
    }
}
