package exceptions;

import java.util.HashMap;
import java.util.Map;

public class Student{
    private String name;
    private HashMap <Subject, Integer> subjectsAndMarks = new HashMap<Subject, Integer>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, HashMap<Subject, Integer> subjectsAndMarks) {
        this.name = name;
        this.subjectsAndMarks = subjectsAndMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Subject, Integer> getSubjectsAndMarks() {
        return subjectsAndMarks;
    }

    public void setSubjectsAndMarks(HashMap<Subject, Integer> subjectsAndMarks) {
        this.subjectsAndMarks = subjectsAndMarks;
    }

    public double averageMark(){
        double sumOfMarks=0;
        for (Subject subject:subjectsAndMarks.keySet()) {
            sumOfMarks += subjectsAndMarks.get(subject);
        }
        return sumOfMarks/subjectsAndMarks.size();
    }
}