package exceptions;

import java.util.ArrayList;
import java.util.List;

public class University implements AverageSubjectMarkCalculable{
    private String name;
    private ArrayList<Faculty> facultyList = new ArrayList<Faculty>();

    public University(String name) {
        this.name = name;
    }

    public University(String name, ArrayList<Faculty> facultyList) {
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

    public void setFacultyList(ArrayList<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public Float CalculateAverageMarkOnSubject(Subject subject) {
        float sumOfMarks = 0;
        int iterator =0;
        for (Faculty faculty:facultyList) {
            if (faculty.CalculateAverageMarkOnSubject(subject) != null) {
                sumOfMarks += faculty.CalculateAverageMarkOnSubject(subject);
                iterator++;
            }
        }
        if (iterator > 0){
            return sumOfMarks/iterator;
        }else return null;
    }
}