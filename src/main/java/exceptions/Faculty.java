package exceptions;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements AverageSubjectMarkCalculable{
    String name;
    ArrayList<Group> groupList = new ArrayList<Group>();

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

    public float CalculateAverageMarkOnSubject(Subject subject) {
        float sumOfMarks = 0;
        for (Group group : groupList) {
            sumOfMarks += group.CalculateAverageMarkOnSubject(subject);
            System.out.println(sumOfMarks);
        }
        return sumOfMarks/groupList.size();
    }
}
