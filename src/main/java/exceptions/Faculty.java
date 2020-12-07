package exceptions;

import java.util.List;

public class Faculty{
    String name;
    List<Group> groupList;

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, List<Group> groupList) {
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

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
