package exceptions;

import java.util.ArrayList;

public class Faculty implements AverageSubjectMarkCalculable {
    private String name;
    private ArrayList<Group> groupList = new ArrayList<>();

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

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public Float calculateAverageMarkOnSubject(Subject subject) throws Exception {
        if (groupList.isEmpty()) throw new Exception("Have no groups");
        float sumOfMarks = 0;
        int iterator = 0;
        for (Group group : groupList) {
            if (group.calculateAverageMarkOnSubject(subject) != null) {
                sumOfMarks += group.calculateAverageMarkOnSubject(subject);
                iterator++;
            }
        }
        if (iterator > 0) {
            return sumOfMarks / iterator;
        } else return null;
    }

    public Float getAverageMark(String groupName, Subject subject) throws Exception {
        for (Group group : groupList) {
            if (group.getName().equals(groupName)) {
                return group.calculateAverageMarkOnSubject(subject);
            }
        }
        return null;
    }
}