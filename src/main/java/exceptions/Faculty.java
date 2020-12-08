package exceptions;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements AverageSubjectMarkCalculable{
    private String name;
    private ArrayList<Group> groupList = new ArrayList<Group>();

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, ArrayList<Group> groupList) {
        this.name = name;
        this.groupList = groupList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    public Float CalculateAverageMarkOnSubject(Subject subject) {
        float sumOfMarks = 0;
        int iterator = 0;
        for (Group group : groupList) {
            if (group.CalculateAverageMarkOnSubject(subject) != null) {
                sumOfMarks += group.CalculateAverageMarkOnSubject(subject);
                iterator++;
            }
        }
        if (iterator > 0){
            return sumOfMarks/iterator;
        }else return null;
    }
}