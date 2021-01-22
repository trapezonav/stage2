package exceptions;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private HashMap<Subject, Integer> subjectsAndMarks = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Map<Subject, Integer> getSubjectsAndMarks() {
        return subjectsAndMarks;
    }

    public void setMarksOnSubjects(Subject subject, Integer mark) throws Exception {
        if (mark >= 0 & mark <= 10) {
            subjectsAndMarks.put(subject, mark);
        } else throw new Exception("Incorrect mark");

    }

    public Integer getMarkBySubject(Subject subject) throws Exception {
        if (subjectsAndMarks.isEmpty()) throw new Exception("Student have no subjects");
        return subjectsAndMarks.get(subject);
    }

    public double averageMark() throws Exception {
        if (subjectsAndMarks.isEmpty()) throw new Exception("Student have no subjects");
        double sumOfMarks = 0;
        int iterator = 0;
        for (Subject subject : subjectsAndMarks.keySet()) {
            if (subjectsAndMarks.get(subject) != null) {
                sumOfMarks += subjectsAndMarks.get(subject);
                iterator++;
            }
        }
        if (iterator > 0) {
            return sumOfMarks / iterator;
        } else throw new Exception("Student have no marks");
    }
}