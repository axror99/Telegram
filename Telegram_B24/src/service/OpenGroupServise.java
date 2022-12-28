package service;

import model.Group;
import model.User;

public class OpenGroupServise {
    static int size = 6;
    private Group[] groupOpens = new Group[size];
    private static int index = 0;

    public OpenGroupServise() {
    }

    public boolean addGroup(Group group) {
        if (getGroupBylink(group.getLink()) != null) {
            return false;
        }
        groupOpens[index++] = group;
        return true;
    }

    private Group getGroupBylink(String link) {
        for (Group group : groupOpens) {
            if (group != null) {
                if (group.getLink().equals(link)) {
                    return group;
                }
            }
        }
        return null;
    }

    public Group getgroupInService(int id) {
        int count = 1;
        for (Group group : groupOpens) {
            if (group != null) {
                if (count == id) {
                    return group;
                }
                count++;
            }
        }
        return null;
    }

    boolean addPersonInGroup(User[][] groupPersons, User user, Group currentgroup) {
        int empty = -1;

        for (int j = 0; j < groupPersons[currentgroup.getId()].length; j++) {
            if (groupPersons[currentgroup.getId()][j] == null) {
                empty = j;
                break;
            }
        }
        if (empty != -1) {
            groupPersons[currentgroup.getId()][empty] = user;
            return true;
        } else {
            return false;
        }
    }

    public void showPersonsInGroup(Group currentGroup, User[][] groupPersons) {
        int count=1;
        for (int i = 0; i <groupPersons.length; i++) {
            if (groupPersons[currentGroup.getId()][i] != null)
            {
                System.out.println(count+". "+groupPersons[currentGroup.getId()][i].getName());
                count++;
            }
        }
    }

    public void showGroup() {
        int count = 1;
        for (Group group : groupOpens) {
            if (group != null) {
                System.out.println(count + ". " + group.getName());
                count++;
            }
        }
        System.out.println("-> 0.exit");
    }
}
