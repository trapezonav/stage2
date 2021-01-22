package exceptions;

import java.util.ArrayList;

public class Group implements AverageSubjectMarkCalculable {
    private String name;
    private ArrayList<Student> studentList = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public Float calculateAverageMarkOnSubject(Subject subject) throws Exception {
        if (studentList.isEmpty()) throw new Exception("Have no students");
        float mark = 0;
        int iterator = 0;
        for (Student student : studentList) {
            Integer markBySubject = student.getMarkBySubject(subject);
            if (markBySubject != null) {
                mark += markBySubject;
                iterator++;
            }
        }
        if (iterator > 0) {
            return mark / iterator;
        } else return null;
    }
}
