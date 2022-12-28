package service;

import front.UserDto;
import model.Group;
import model.User;

import java.util.Scanner;

public class PersonalChatService {
    private String s1;
    private static String[][] chats = new String[15][100];
    private static String[][] groupChats = new String[5][100];
    Scanner kiritish = new Scanner(System.in);
    Scanner kiritishStr=new Scanner(System.in);

    public PersonalChatService() {
    }

    public void chatWithMe(User currentUser, Scanner scanner) {
        String var = "=>1";

        int id = currentUser.getId();
        int count = previousChats(currentUser.getId());
        while (!var.equals("=>0")) {
            if (var.equals("=>1")) {
                System.out.print("[ Me ]: ");
                s1 = kiritish.nextLine();
                chats[id][count++] = "[ Me ]: " + s1;
            } else if (var.equals("=>2")) {
                System.out.print("[ " + currentUser.getName() + " ]: ");
                s1 = kiritish.nextLine();
                chats[id][count++] = "[ " + currentUser.getName() + " ]: " + s1;
            }
            var = scanner.next();
        }
    }

    private int previousChats(int id) {
        for (int i = 0; i < 15; i++) {
            if (i == id) {
                for (int j = 0; j < 100; j++) {
                    if (chats[i][j] != null) {
                        System.out.println(chats[i][j]);
                    } else {
                        return j;
                    }
                }
            }
        }
        return 0;
    }

    public void chatwithGroup(Group currentGroup, UserService userService, OpenGroupServise openGroupServise) {
        String var = "10";
        while (!var.equals("0")) {
            System.out.println("1. Add person   2.Start chat   0.Exit");
            var = kiritish.next();
            switch (Integer.parseInt(var)) {
                case 1 -> {
                    userService.showlistOpenGroupsPerson(kiritish, currentGroup);
                }
                case 2 -> {
                    openGroupServise.showPersonsInGroup(currentGroup,UserService.groupPersons);
                    realchatWithGroup(currentGroup,UserService.groupPersons);
                }
            }

        }
    }
    private void realchatWithGroup(Group currentGroup, User[][] groupPersons)
    {
        int id = currentGroup.getId();
        int ran = howmanyPersonInGroup(id, groupPersons);
        String temp;
        if (ran==0) {
            System.out.println("=>0. Exit ");
            temp = kiritish.next();
            if (temp.equals("=>0")) {
                System.out.println("------------------------------");
            }
        }
        else {
            System.out.println("=>0. Exit ");
            System.out.println("------------------------------");

            int count = previousChatsWithGroup(id);
            while (true) {
                System.out.print("[ Me ]: ");
                s1 = kiritishStr.nextLine();
                temp=s1;
                if (temp.equals("=>0")) {return;}
                groupChats[id][count++] = "[ Me ]: " + s1;
                for (int i = 0; i < 3; i++) {
                   int ran2 = (int) (Math.random()*(ran));
                    System.out.print("[ " + groupPersons[id][ran2].getName() + " ]: ");
                    s1 = kiritishStr.nextLine();
                    groupChats[id][count++] = "[ " + groupPersons[id][ran2].getName() + " ]: " + s1;
                }
            }
        }
    }
    private int previousChatsWithGroup(int id) {

                for (int j = 0; j < 100; j++) {
                    if (groupChats[id][j] != null) {
                        System.out.println(groupChats[id][j]);
                    } else {
                        return j;
                    }
                }
        return 0;
    }
    private int howmanyPersonInGroup(int id,User[][] groupPersons)
    {
        int count=0;
        for (int i = 0; i < groupPersons[id].length; i++) {
            if (groupPersons[id][i] != null)
            {
                count++;
            }
        }
        return count;
    }
}