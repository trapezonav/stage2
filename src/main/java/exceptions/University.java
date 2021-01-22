package exceptions;

import java.util.ArrayList;

public class University implements AverageSubjectMarkCalculable {
    private String name;
    private ArrayList<Faculty> facultyList = new ArrayList<>();

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

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public Float calculateAverageMarkOnSubject(Subject subject) throws Exception {
        if (facultyList.isEmpty()) throw new Exception("Have no faculty");
        float sumOfMarks = 0;
        int iterator = 0;
        for (Faculty faculty : facultyList) {
            if (faculty.calculateAverageMarkOnSubject(subject) != null) {
                sumOfMarks += faculty.calculateAverageMarkOnSubject(subject);
                iterator++;
            }
        }
        if (iterator > 0) {
            return sumOfMarks / iterator;
        } else return null;
    }
}