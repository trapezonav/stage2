package exceptions;

import java.util.HashMap;
import java.util.Map;

public class Student implements AverageSubjectMarkCalculable{
    String name;
    HashMap <Subject, Integer> subjectsAndMarks = new HashMap<Subject, Integer>();

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
        double result=0;
        for (Subject subject:subjectsAndMarks.keySet()) {
            result += subjectsAndMarks.get(subject);
        }

        return result/subjectsAndMarks.size();
    }

    public float CalculateAverageMarkOnSubject(Subject subject) {
        return subjectsAndMarks.get(subject);
    }
}
