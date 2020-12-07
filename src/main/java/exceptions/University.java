package exceptions;

import java.util.List;

public class University {
    String name;
    List <Faculty> facultyList;

    public University(String name) {
        this.name = name;
    }

    public University(String name, List<Faculty> facultyList) {
        this.name = name;
        this.facultyList = facultyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }
}
