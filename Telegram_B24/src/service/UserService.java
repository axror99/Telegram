package service;

import model.Group;
import model.User;

import java.util.Arrays;
import java.util.Scanner;

public class UserService {

    private User[] allUser = new User[10];
    private User[] searcheUser = new User[5];
    private User[][] fakegroupPersons = new User[OpenGroupServise.size][allUser.length];
    static User[][] groupPersons = new User[OpenGroupServise.size][8];
    private static int index = 0;


    public UserService() {
        User user1 = new User(false, false, false, "donyor", "@Emro");
        User user2 = new User(false, false, false, "ulugbek", "@Don");
        User user3 = new User(false, false, false, "Kamoliddin", "faxridinnov");
        User user4 = new User(false, false, false, "Otabek", "Shokirov");
        User user5 = new User(false, false, false, "Bunyod", "Omonov");
        searcheUser[0] = user1;
        searcheUser[1] = user2;
        searcheUser[2] = user3;
        searcheUser[3] = user4;
        searcheUser[4] = user5;
    }

    public User[] getSearcheUser() {
        return searcheUser;
    }

    public boolean addUsertoRegistrion(User user) {
        if (getUserByusername(user.getUsername()) != null) {
            return false;
        }
        allUser[index++] = user;
        return true;
    }

    public User getUserByusername(String username) {
        for (User user : allUser)
            if (user != null) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        return null;
    }

    // Polymorphism =================
    public void showlistOnePerson() {
        int count = 1;
        for (User user : allUser) {
            if (user != null) {
                System.out.println("  " + count + ". " + user.getName());
                count++;
            }
        }
        System.out.println("-> 0.exit");
    }

    // Polymorphism=============
    public void showlistOnePerson(User[][] groupPersons, Group currentGroup) {
        //User[][] fakegroupPersons=new User[OpenGroupServise.size][allUser.length];
        for (int i = 0; i < allUser.length; i++) {
            fakegroupPersons[currentGroup.getId()][i] = allUser[i];
        }
        int row = currentGroup.getId();
        for (int j = 0; j < allUser.length; j++) {

            if (fakegroupPersons[row][j] != null) {
                for (int i = 0; i < groupPersons[currentGroup.getId()].length; i++) {
                    if (groupPersons[currentGroup.getId()][i] != null) {
                        if (fakegroupPersons[row][j].getUsername().equals(groupPersons[currentGroup.getId()][i].getUsername())) {
                            fakegroupPersons[row][j] = null;
                            break;
                        }
                    }
                }
            }
        }
        fakeShowPersonInGroup(fakegroupPersons, currentGroup.getId());
        System.out.println("-> 0.exit");
    }

    private void fakeShowPersonInGroup(User[][] arr, int tartib) {
        arr = moveZeroToEnd(arr, tartib);
        int count = 1;
        for (int i = 0; i < arr[tartib].length; i++) {
            if (arr[tartib][i] != null) {
                System.out.println(count + ". " + arr[tartib][i].getName());
                count++;
            }
        }
    }

    private User[][] moveZeroToEnd(User[][] arr, int tartib) {
        int j = 0;
        for (int i = 0; i < arr[tartib].length; i++) {
            if (arr[tartib][i] != null) {
                swap(arr, i, j, tartib);
                j++;
            }
        }
        return arr;
    }

    private void swap(User[][] a, int i, int j, int t) {
        User temp = a[t][i];
        a[t][i] = a[t][j];
        a[t][j] = temp;
    }

    public void showlistOpenGroupsPerson(Scanner sc, Group currentgroup) {
        String s1 = "";
        OpenGroupServise openGroupServise = new OpenGroupServise();
        while (!s1.equals("0")) {
            System.out.println("---------------------------------");
            System.out.println("-> * .Search new person");
            showlistOnePerson(groupPersons, currentgroup);
            System.out.println("---------------------------------");
            s1 = sc.next();
            if (s1.equals("*")) {
                System.out.println("enter new  person's  username :");
                String s2 = sc.next();
                for (int i = 0; i < searcheUser.length; i++) {
                    if (searcheUser[i].getUsername().equals(s2)) {
                        System.out.println("Found !!!");
                        System.out.println("Will  you add  this  person ?");
                        System.out.println("1. Add    0.Exit");
                        int a = sc.nextInt();
                        if (a == 1) {
                            System.out.println(openGroupServise.addPersonInGroup(groupPersons, searcheUser[i], currentgroup));
                            return;
                        } else if (a == 0)
                            return;
                    }
                }
                System.out.println("Not  Found !!!");
            } else if (Integer.parseInt(s1) > 0) {
                User user = getUserInService(Integer.parseInt(s1), currentgroup.getId());
                System.out.println(openGroupServise.addPersonInGroup(groupPersons, user, currentgroup));
                return;
            }
        }
    }

    public User getUserInService(int check, int tartib) {
        int count = 1;
        for (User user : fakegroupPersons[tartib]) {
            if (user != null) {
                if (check == count) {
                    return user;
                }
                count++;
            }
        }
        return null;
    }

    public User getUserInService(int check) {
        int count = 1;
        for (User user : allUser) {
            if (user != null) {
                if (check == count) {
                    return user;
                }
                count++;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "allUser=" + Arrays.toString(allUser) +
                '}';
    }
}


