package exceptions;

import java.util.ArrayList;
import java.util.List;

public class Group implements AverageSubjectMarkCalculable{
    String name;
    ArrayList<Student> studentList = new ArrayList<Student>();

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, ArrayList<Student> studentList) {
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

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public float CalculateAverageMarkOnSubject(Subject subject) {
        float mark=0;
        int iterator = 0;
        for (Student student : studentList) {
            if (student.subjectsAndMarks.get(subject) != null){
                mark += student.subjectsAndMarks.get(subject);
                iterator++;
                System.out.println(mark + " " + iterator);
            }
        }
        return mark/iterator;
    }
}
