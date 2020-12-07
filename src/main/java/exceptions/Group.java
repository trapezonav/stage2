package exceptions;

import java.util.List;

public class Group {
    String name;
    List<Student> studentList;

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
