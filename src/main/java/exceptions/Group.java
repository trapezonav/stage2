package exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public Float calculateAverageMarkOnSubject(Subject subject) {
        float mark=0;
        int iterator = 0;
        for (Student student : studentList) {
            Map<Subject, Integer> marksBySubject = student.getSubjectsAndMarks();
            if (marksBySubject.containsKey(subject)){
                mark += marksBySubject.get(subject);
                iterator++;
            }
        }
        if (iterator > 0 ){
            return mark/iterator;
        }else return null;
    }
}
